package com.zihler.courses;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
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
                .parseXHtml(writer, document, new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8)));
        document.close();

        return os.toByteArray();
    }

    public byte[] convertToPdf(Course course, List<CourseSection> courseSections) throws IOException, DocumentException {
//        ByteCollector pdfBytesCollector = new ByteCollector();
//
//        Markdown2PdfConverter.newConverter()
//                .readFrom(() -> formatForPdf(course, courseSections))
//                .writeTo(pdfBytesCollector)
//                .doIt();
//
//        return pdfBytesCollector.getBytes();
        MutableDataSet options = new MutableDataSet();

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = parser.parse(formatForPdf(course, courseSections));
        String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"

        return generatePDFFromHTML(html);
    }
    private String formatForPdf(Course course, List<CourseSection> courseSections) {
        String formatted = "# " + course.getTitle();
        formatted += "\n## " + course.getDescription();

        for (CourseSection courseSection : courseSections) {
            formatted += "\n# " + courseSection.getSectionTitle();
            formatted += "\n" + courseSection.getSectionMarkdown();
        }
        return formatted;
    }


}
