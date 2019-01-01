package com.zihler.courses;

import com.qkyrie.markdown2pdf.Markdown2PdfConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;
import com.qkyrie.markdown2pdf.internal.writing.Markdown2PdfWriter;
import com.zihler.courses.dataaccess.Course;
import com.zihler.courses.dataaccess.CourseSection;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseToPdfService")
public class Course2PdfService {
    public byte[] convertToPdf(Course course, List<CourseSection> courseSections) throws ConversionException, Markdown2PdfLogicException {
        ByteCollector pdfBytesCollector = new ByteCollector();

        Markdown2PdfConverter.newConverter()
                .readFrom(() -> formatForPdf(course, courseSections))
                .writeTo(pdfBytesCollector)
                .doIt();

        return pdfBytesCollector.getBytes();
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

    private class ByteCollector implements Markdown2PdfWriter {

        private byte[] bytes;

        @Override
        public void write(byte[] out) {
            this.bytes = out;
        }

        public byte[] getBytes() {
            return bytes;
        }

        public void setBytes(byte[] bytes) {
            this.bytes = bytes;
        }
    }
}
