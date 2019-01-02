package com.zihler.courses;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.qkyrie.markdown2pdf.internal.writing.Markdown2PdfWriter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.zihler.courses.dataaccess.Course;
import com.zihler.courses.dataaccess.CourseSection;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service("courseToPdfService")
public class Course2PdfService {
    private static byte[] generatePDFFromHTML(String html) throws IOException, DocumentException {
        Document document = new Document();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, os);
        document.open();
        XMLWorkerHelper.getInstance()
                .parseXHtml(writer,
                        document,
                        new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8))
                );
        document.close();

        return os.toByteArray();
    }

    public byte[] convertToPdfSimple(Course course, List<CourseSection> courseSections) {
        try {
            ByteCollector pdfBytesCollector = new ByteCollector();

            Markdown22PdfConverter.newConverter()
                    .readFrom(() -> formatForPdf(course, courseSections))
                    .writeTo(pdfBytesCollector)
                    .doIt();

            return pdfBytesCollector.getBytes(); //doesn't produce utf 8... errors
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not parse course with id %s.", course.getId()), e);
        }
    }

    byte[] convertToPdf(Course course, List<CourseSection> courseSections) {
        try {
            MutableDataSet options = new MutableDataSet();

            Parser parser = Parser.builder(options).build();
            HtmlRenderer renderer = HtmlRenderer.builder(options).build();

            String markdownInput = formatForPdf(course, courseSections);
            Node document = parser.parse(markdownInput);
            String html = renderer.render(document);

            html = "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head></head>\n" +
                    "<body style=\"font-family: Arial, Helvetica, sans-serif; \">\n" +
                    html + "\n" +
                    "</body>\n" +
                    "</html>";
            return Markdown22PdfConverter.convert(html);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Could not parse course with id %s.", course.getId()), e);
        }
    }

    private String formatForPdf(Course course, List<CourseSection> courseSections) {
        StringBuilder formatted = new StringBuilder("# " + course.getTitle() + "\n");
        formatted.append("## ")
                .append(course.getDescription())
                .append("\n");

        for (CourseSection courseSection : courseSections) {
            formatted.append("# ")
                    .append(courseSection.getSectionTitle())
                    .append("\n")
                    .append(courseSection.getSectionMarkdown())
                    .append("\n");
        }
        return formatted.toString();
    }

    private class ByteCollector implements Markdown2PdfWriter {

        private byte[] bytes;

        @Override
        public void write(byte[] out) {
            this.bytes = out;
        }

        byte[] getBytes() {
            return bytes;
        }

        public void setBytes(byte[] bytes) {
            this.bytes = bytes;
        }
    }
}
