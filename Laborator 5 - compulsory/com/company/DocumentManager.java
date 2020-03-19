package com.company;

import com.company.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DocumentManager {

    private Document document;
    private Desktop desktop;

    public DocumentManager(Document doc) {
        this.document = doc;
        this.desktop = Desktop.getDesktop();
    }

    public void view() throws IOException {
        desktop.open(new File(document.getPath()));
    }

}
