package com.company;

import com.company.errors.NullObject;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * @author Elisa Giurgea
 */

public class Main {

    public static void main(String[] args) {

        Document doc = new Document(3, "/home/elisa/Desktop/doc.txt", null);
        DocumentManager docManager = new DocumentManager(doc);

        try {
            docManager.view();
        } catch (IOException error) {
            error.printStackTrace();
        }

        Catalog catalogNew = new Catalog();
        catalogNew.addDocuments(new Document(1, "/home/elisa", null), new Document(2, "/home/elisa/Workspace", null));
        CatalogManager manager = new CatalogManager(catalogNew);

        try {
            saveAndLoad(manager);
        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace();
        } catch (NullObject nullObject) {
            System.out.println(nullObject);
            nullObject.printStackTrace();
        }

    }

    private static void saveAndLoad(CatalogManager manager) throws IOException, NullObject, ClassNotFoundException {
        manager.save("/home/elisa/foldernew");
        manager.load("/home/elisa/foldernew");
        Catalog newCatalog = manager.getCatalog();

        System.out.println(newCatalog);
    }
}
