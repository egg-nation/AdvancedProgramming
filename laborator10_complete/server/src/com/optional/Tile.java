package com.optional;

public class Tile {

    private int positionX;
    private int positionY;

    private int value;

    public Tile(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;

        value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setPosX(int positionX) {
        this.positionX = positionX;
    }

    public String getPosX() {
        return String.valueOf(positionX);
    }

    public void setPosY(int positionY) {
        this.positionY = positionY;
    }

    public String getPosY() {
        return String.valueOf(positionY);
    }
}
