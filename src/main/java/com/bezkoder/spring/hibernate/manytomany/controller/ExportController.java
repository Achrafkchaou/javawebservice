package com.bezkoder.spring.hibernate.manytomany.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.bezkoder.spring.hibernate.manytomany.model.Entry;
import com.bezkoder.spring.hibernate.manytomany.repository.ExportServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller

public class ExportController {

    @Autowired
    private ExportServices service;

    @GetMapping("/generate")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=dataset_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Entry> listEntrys = service.listAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = { "ID", "TEXT", "LABELS" };
        String[] nameMapping = { "id", "text", "labels" };

        csvWriter.writeHeader(csvHeader);

        for (Entry entry : listEntrys) {
            csvWriter.write(entry, nameMapping);
        }

        csvWriter.close();

    }
}
