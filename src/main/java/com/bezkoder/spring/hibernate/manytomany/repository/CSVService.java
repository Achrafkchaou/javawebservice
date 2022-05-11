package com.bezkoder.spring.hibernate.manytomany.repository;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.bezkoder.spring.hibernate.manytomany.model.CSVHelper;
import com.bezkoder.spring.hibernate.manytomany.model.Entry;
//import com.bezkoder.spring.hibernate.manytomany.model.Label;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CSVService {
    @Autowired
    EntryRepository repository;
    // @Autowired
    // LabelRepository repository1;

    public ByteArrayInputStream load() {
        List<Entry> entrys = repository.findAll();

        ByteArrayInputStream in = CSVHelper.entrysToCSV(entrys);
        return in;
    }

    // public ByteArrayInputStream loadd() {
    // List<Label> labels = repository1.findAll();

    // ByteArrayInputStream in = CSVHelper.labelsToCSV(labels);
    // return in;
    // }
}