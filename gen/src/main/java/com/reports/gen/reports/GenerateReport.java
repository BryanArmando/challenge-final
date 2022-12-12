package com.reports.gen.reports;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.reports.gen.entity.Exams;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GenerateReport {
    private List<Exams> listEx;

    public GenerateReport(List<Exams> listExamen) {
        super();
        this.listEx = listExamen;
    }

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();

        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);

        com.lowagie.text.Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Azucar", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Grasa", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Oxigeno", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Riesgo", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("Usuario", fuente));
        tabla.addCell(celda);

    }

    private void escribirDatosDeLaTabla(PdfPTable tabla) {
        for (Exams exams : listEx) {
            tabla.addCell(String.valueOf(exams.getId()));
            tabla.addCell(String.valueOf(exams.getAzucar()));
            tabla.addCell(String.valueOf(exams.getGrasa()));
            tabla.addCell(String.valueOf(exams.getOxigeno()));
            tabla.addCell(exams.getRiesgo());
            tabla.addCell(String.valueOf(exams.getUsuarioId()));
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4);
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();
        Image header =Image.getInstance("https://www.salud.mapfre.es/media/2016/07/analisis-de-sangre1.jpg");
        header.scaleToFit(600, 1000);
        header.setAlignment(Chunk.ALIGN_CENTER);

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);
        documento.add(header);

        Paragraph titulo = new Paragraph("Análisis de Sangre Realizados", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(6);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] { 1f, 2.3f, 4.5f, 6f, 3.9f, 4.5f });
        tabla.setWidthPercentage(110);

        escribirCabeceraDeLaTabla(tabla);
        escribirDatosDeLaTabla(tabla);

        documento.add(tabla);
        documento.close();
    }
}