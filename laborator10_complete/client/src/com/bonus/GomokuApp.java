package com.bonus;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.compulsory.Socket;
import javafx.application.Application;
import javafx.scene.Parent;

public class GomokuApp extends Application {

    private static int xMovePlayer;
    private static int yMovePlayer;
    private static Object GameClient;
    private static Tile[][] tiles;

    private Parent createContent() {
        int i, j;

        Pane root = new Pane();
        root.setPrefSize(800, 800);
        tiles = new Tile[8][8];

        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                Tile tile = new Tile(i, j);
                tile.setTranslateX(j * 100);
                tile.setTranslateY(i * 100);
                tiles[i][j] = tile;
                root.getChildren().add(tile);
            }
        }

        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    public static void setBoard(int size) {
        int i, j;

        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                tiles[i][j].setText("");
            }
        }

        System.out.println("Board set ");
    }

    public static void main(String[] args) {
        new Socket().start();
        launch(args);
    }

    public static void printWinner(String winner) {
        int i;

        String player = "Player ";
        String wins = "wins! ";

        for (i = 0; i < 7; i++) {
            tiles[2][i].setText(String.valueOf(player.charAt(i)));
        }

        tiles[2][7].setText(winner);

        for (i = 0; i < 5; i++) {
            tiles[5][i + 1].setText(String.valueOf(wins.charAt(i)));
        }
    }

    public static int getxMove() {
        return xMovePlayer;
    }

    public static void setxMove(int xMovePlayer) {
        GomokuApp.xMovePlayer = xMovePlayer;
    }

    public static int getyMove() {
        return yMovePlayer;
    }

    public static void setyMove(int yMovePlayer) {
        GomokuApp.yMovePlayer = yMovePlayer;
    }


    public static void sendMoves(Tile tile) {
        xMovePlayer = tile.getPosX();
        yMovePlayer = tile.getPosY();
    }

    public static void setMoves(String row, String col) {
        int rowInt = Integer.parseInt(row);
        int colInt = Integer.parseInt(col);

        tiles[rowInt][colInt].setText("O");
    }

    public static String getCoordinates(String type) {
        String coordinates;

        if (type.compareTo("X") == 0) {
            coordinates = String.valueOf(xMovePlayer);
        }
        else {
            coordinates = String.valueOf(yMovePlayer);
        }

        return coordinates;
    }

}
