package com.company;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.*;


public class Catalog implements Serializable {

    private List<Document> documents;

    Catalog() {
        this.documents = new ArrayList<Document>();
    }

    public Catalog(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocuments(Document ... documents) {
        this.documents.addAll(Arrays.asList(documents));
    }

    @Override
    public String toString() {
        return "Catalog{" + documents + '}';
    }

}
