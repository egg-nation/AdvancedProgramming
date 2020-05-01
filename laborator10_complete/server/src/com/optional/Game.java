package com.optional;

//game

public class Game {
    private Player currPlayer;
    private Tile lastMove;
    private HtmlReport htmlReport;
    private Board board;
    private Player player1;
    private Player player2;

    public Game(int sizeOfBoard) {
        board = new Board(sizeOfBoard);
        player1 = new Player(1);
        player2 = new Player(2);
        currPlayer = player1;
        htmlReport = new HtmlReport();
    }

    public void setCurrPlayer(Player currPlayer) {
        this.currPlayer = currPlayer;
    }

    public Player getCurrPlayer() {
        return currPlayer;
    }

    public void setLastMove(Tile lastMove) {
        this.lastMove = lastMove;
    }

    public Tile getLastMove() {
        return lastMove;
    }

    public void setHtmlReport(HtmlReport htmlReport) {
        this.htmlReport = htmlReport;
    }

    public HtmlReport getHtmlReport() {
        return htmlReport;
    }

    public void nextTurn() {
        if (currPlayer == player1) {
            setCurrPlayer(player2);
        }
        else {
            setCurrPlayer(player1);
        }
    }

    public boolean checkWinner() {
        int numberOfPlayer = currPlayer.getNumber();

        if (checkHorizontal(numberOfPlayer)) {
            return true;
        }

        if (checkVertical(numberOfPlayer)) {
            return true;
        }

        if (checkDiagonally(numberOfPlayer)) {
            return true;
        }

        return false;
    }

    public void putPiece(String row, String col) {
        int row1 = Integer.parseInt(row);
        int col1 = Integer.parseInt(col);

        board.getTiles()[row1][col1].setValue(currPlayer.getNumber());
        htmlReport.addPosition(currPlayer.getNumber(), row1, col1);

        lastMove = board.getTiles()[row1][col1];
        nextTurn();
    }

    private boolean checkVertical(int numberOfPlayer) {
        int i, j, k;
        int ok;

        for (i = 0; i < board.getSize() - 5; i++)
            for (j = 0; j < board.getSize(); j++) {
                if (board.getTiles()[i][j].getValue() == numberOfPlayer) {
                    ok = 1;

                    for (k = 0; k < 5; k++) {
                        if (board.getTiles()[i + k][j].getValue() != numberOfPlayer) {
                            ok = 0;
                        }
                    }

                    if (ok != 0){
                        return true;
                    }
                }
            }
        return false;
    }

    private boolean checkHorizontal(int numberOfPlayer) {
        int i, j, k;
        int ok;

        for (i = 0; i < board.getSize(); i++)
            for (j = 0; j < board.getSize() - 5; j++) {
                if (board.getTiles()[i][j].getValue() == numberOfPlayer) {
                    ok = 1;

                    for (k = 0; k < 5; k++) {
                        if (board.getTiles()[i][j + k].getValue() != numberOfPlayer) {
                            ok = 0;
                        }
                    }

                    if (ok != 0){
                        return true;
                    }
                }
            }
        return false;
    }

    private boolean checkDiagonally(int numberOfPlayer) {
        if (checkSecondaryDiag(numberOfPlayer)) {
            return true;
        }

        if (checkFirstDiag(numberOfPlayer)) {
            return true;
        }

        return false;
    }

    private boolean checkSecondaryDiag(int numberOfPlayer) {
        int i, j, k;
        int ok;

        for (i = 0; i < board.getSize() - 5; i++)
            for (j = 4; j < board.getSize() ; j++) {
                if (board.getTiles()[i][j].getValue() == numberOfPlayer) {
                    ok = 1;

                    for (k = 0; k < 5; k++) {
                        if (board.getTiles()[i + k][j - k].getValue() != numberOfPlayer) {
                            ok = 0;
                        }
                    }

                    if (ok != 0) {
                        return true;
                    }
                }
            }
        return false;
    }

    private boolean checkFirstDiag(int numberOfPlayer) {
        int i, j, k;
        int ok;

        for (i = 0; i < board.getSize() - 5; i++)
            for (j = 0; j < board.getSize() - 5; j++) {
                if (board.getTiles()[i][j].getValue() == numberOfPlayer) {
                    ok = 1;

                    for (k = 0; k < 5; k++) {
                        if (board.getTiles()[i + k][j + k].getValue() != numberOfPlayer) {
                            ok = 0;
                        }
                    }

                    if (ok != 0){
                        return true;
                    }
                }
            }
        return false;
    }
}
