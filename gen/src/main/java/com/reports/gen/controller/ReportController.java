package com.reports.gen.controller;

import com.lowagie.text.DocumentException;
import com.reports.gen.entity.Exams;
import com.reports.gen.reports.GenerateReport;
import com.reports.gen.repository.ExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReportController {
    @Autowired
    private ExamsRepository examsRepository;

    @GetMapping("/public/reporte")
    public void exportarPdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Reporte-Analisis" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Exams> examns = examsRepository.findAll();

        GenerateReport exporter = new GenerateReport(examns);
        exporter.exportar(response);
    }

    @GetMapping("/public/reporte/{id}")
    public void exportarPdf(@PathVariable(value = "id") Integer id, HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormatter.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Reporte-Analisis-Usuario" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        List<Exams> examns = examsRepository.findExamsByUsuarioId(id);

        GenerateReport exporter = new GenerateReport(examns);
        exporter.exportar(response);
    }
}
