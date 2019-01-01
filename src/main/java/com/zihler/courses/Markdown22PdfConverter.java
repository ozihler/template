package com.zihler.courses;


import com.lowagie.text.DocumentException;
import com.qkyrie.markdown2pdf.internal.converting.Html2PdfConverter;
import com.qkyrie.markdown2pdf.internal.converting.HtmlCleaner;
import com.qkyrie.markdown2pdf.internal.converting.Markdown2HtmlConverter;
import com.qkyrie.markdown2pdf.internal.exceptions.ConversionException;
import com.qkyrie.markdown2pdf.internal.exceptions.Markdown2PdfLogicException;
import com.qkyrie.markdown2pdf.internal.reading.Markdown2PdfReader;
import com.qkyrie.markdown2pdf.internal.writing.Markdown2PdfWriter;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

/**
 * User: Quinten
 * Date: 31-3-2014
 * Time: 09:43
 *
 * @author Quinten De Swaef
 */
public class Markdown22PdfConverter {
    private Markdown2PdfReader reader;
    private Markdown2PdfWriter writer;
    private Markdown2HtmlConverter markdown2htmlConverter;
    private HtmlCleaner htmlCleaner;
    private Html2PdfConverter html2PdfConverter;


    private Markdown22PdfConverter() {
        this.markdown2htmlConverter = new Markdown2HtmlConverter();
        this.htmlCleaner = new HtmlCleaner();
        this.html2PdfConverter = new Html2PdfConverter();
    }

    public static Markdown22PdfConverter newConverter() {
        return new Markdown22PdfConverter();
    }

    public static byte[] convert(String input) throws ConversionException {
        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(new String(input.getBytes(StandardCharsets.UTF_8)));
            renderer.layout();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw ConversionException.HTML_TO_PDF_EXCEPTION;
        }
    }

    public Markdown22PdfConverter readFrom(Markdown2PdfReader reader) {
        this.reader = reader;
        return this;
    }

    public Markdown22PdfConverter writeTo(Markdown2PdfWriter writer) {
        this.writer = writer;
        return this;
    }

    public void doIt() throws ConversionException, Markdown2PdfLogicException {
        String cleanedHtmlFile = cleanedHtmlFile();
        byte[] convertedPdfFile = convert(cleanedHtmlFile);
        writer.write(convertedPdfFile);
    }

    public String cleanedHtmlFile() throws Markdown2PdfLogicException, ConversionException {
        validateLogicBeforeExecution();
        String originalMarkdownFile = reader.read();
        String htmlFile = markdown2htmlConverter.convert(originalMarkdownFile);
        return htmlCleaner.clean(htmlFile);
    }

    private void validateLogicBeforeExecution() throws Markdown2PdfLogicException {
        if (this.reader == null) {
            throw Markdown2PdfLogicException.LOGIC_SETUP_READER;
        }
        if (this.writer == null) {
            throw Markdown2PdfLogicException.LOGIC_SETUP_WRITER;
        }
    }

}
