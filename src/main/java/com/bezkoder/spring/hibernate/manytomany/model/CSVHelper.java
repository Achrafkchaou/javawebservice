package com.bezkoder.spring.hibernate.manytomany.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

public class CSVHelper {
    public static ByteArrayInputStream entrysToCSV(List<Entry> entrys) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Entry entry : entrys) {
                List<String> data = Arrays.asList(
                        String.valueOf(entry.getId()),
                        entry.getText());

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " +
                    e.getMessage());
        }
    }

    // public static ByteArrayInputStream labelsToCSV(List<Label> labels) {
    // final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    // try (ByteArrayOutputStream out = new ByteArrayOutputStream();
    // CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
    // for (Label label : labels) {
    // List<String> data = Arrays.asList(
    // String.valueOf(label.getId()),
    // label.getName());

    // csvPrinter.printRecord(data);
    // }

    // csvPrinter.flush();
    // return new ByteArrayInputStream(out.toByteArray());
    // } catch (IOException e) {
    // throw new RuntimeException("fail to import data to CSV file: " +
    // e.getMessage());
    // }
    // }
}
