package com.github.stykus666.PDF_generator.service;


import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

@Service
public class PDFGeneratorService {

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        fontTitle.setColor(Color.GREEN);

        Paragraph paragraphTitle = new Paragraph("This is Helvetica Bold title in green.", fontTitle);
        paragraphTitle.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        fontParagraph.setColor(Color.BLUE);

        Paragraph paragraphBelowTitle = new Paragraph("This is Helvetica paragraph in blue.", fontParagraph);
        paragraphBelowTitle.setAlignment(Paragraph.ALIGN_LEFT);


        document.add(paragraphTitle);
        document.add(paragraphBelowTitle);

        document.close();

    }
}
