package com.company;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable
{

    private long ID;
    private String path;
    private Map<String, String> tags;

    public Document() {
        this.tags = new HashMap<String, String>();
    }

    public Document(long ID, String path, Map<String, String> tags) {
        this.ID = ID;
        this.path = path;
        this.tags = tags;
    }

    public long getUniqueID() {
        return ID;
    }

    public void setUniqueID(long ID) {
        this.ID = ID;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getTags() {
        return tags;
    }

    public void setTags(Map<String, String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                " ID: " + ID +
                ", path: '" + path +
                ", tags: " + tags +
                '}';
    }
}
