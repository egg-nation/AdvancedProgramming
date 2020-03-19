package com.company;

import com.company.*;
import com.company.errors.NullObject;

import java.io.*;

public class CatalogManager {

    public Catalog catalog;

    public CatalogManager(Catalog catalog) {
        this.catalog = catalog;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public void load(String path) throws IOException, ClassNotFoundException {

        FileInputStream stream = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(stream);
        setCatalog((Catalog)in.readObject());
    }

    public void save(String path) throws IOException, NullObject {
        if (catalog == null) {
            throw new NullObject("Catalog");
        }

        FileOutputStream stream = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(stream);
        out.writeObject(catalog);
    }

}
