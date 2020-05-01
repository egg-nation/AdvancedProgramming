package com.bonus;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile extends StackPane {
    private int positionX;
    private int positionY;
    private Text text = new Text();

    public Tile(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;

        init();
        setOnMouseClicked(event -> {
            text.setText("X");
            GomokuApp.sendMoves(this);
        });
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setPosX(int positionX) {
        this.positionX = positionX;
    }

    public int getPosX() {
        return positionX;
    }

    public void setPosY(int positionY) {
        this.positionY = positionY;
    }

    public int getPosY() {
        return positionY;
    }

    private void init() {
        Rectangle border = getRectangle(100, 100, Color.BLACK);
        setAlignment(Pos.CENTER);

        text.setFont(Font.font(40));
        getChildren().addAll(border, text);
    }

    private Rectangle getRectangle(int width, int height, Color color) {
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setFill(null);
        rectangle.setStroke(color);
        return rectangle;
    }
}