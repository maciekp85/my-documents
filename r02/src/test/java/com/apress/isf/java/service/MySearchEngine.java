package com.apress.isf.java.service;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishi on 2016-03-29.
 */
public class MySearchEngine implements SearchEngine {

    public List<Document> findByType(Type documentType) {
        List<Document> result = new ArrayList<Document>();
        for(Document document: storage()) {
            if(document.getType().getName().equals(documentType.getName()))
                result.add(document);
        }

        return result;
    }

    public List<Document> listAll() {
        return storage();
    }

    private List<Document> storage() {
        List<Document> result = new ArrayList<Document>();

        Type type = new Type();
        type.setName("PDF");
        type.setDesc("Portable Document Format");
        type.setExtension(".pdf");

        Document document = new Document();
        document.setName("Szablon książek");
        document.setType(type);
        document.setLocation("/Document/Book Template.pdf");

        result.add(document);

        document = new Document();
        document.setName("Przykładowa umowa");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Contracts/Przykladowa umowa.pdf");

        result.add(document);

        type = new Type();
        type.setName("NOTE");
        type.setDesc("Notatki tekstowe");
        type.setExtension(".txt");

        document = new Document();
        document.setName("Clustering with RabbitMQ");
        document.setType(type);
        document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");

        result.add(document);

        type = new Type();
        type.setName("WEB");
        type.setDesc("Lacze sieciowe");
        type.setExtension(".url");

        document = new Document();
        document.setName("Pro Spring Security Book");
        document.setType(type);
        document.setLocation("http://www.apress.com/9781430248187");

        result.add(document);

        return result;
    }
}
