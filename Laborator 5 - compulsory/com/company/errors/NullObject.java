package com.company.errors;

public class NullObject extends Throwable {

    private String output;

    public NullObject(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "NullObject {" + output + '}';
    }
}
