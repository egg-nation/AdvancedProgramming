package com.optional;

public class HtmlReport {
    String html;

    public HtmlReport() {
        html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                   "<head>\n" +
                        "<title>GomokuGame</title>\n" +
                   "</head>\n" +
                    "<body>\n" +
                        "\n" +
                        "<h2>Gomoku Game</h2>\n" +
                        "<p>These are the coordinates of the moves of the players</p>\n" +
                        "<ul>";
    }

    public void addPosition(int playerNumber, int x, int y) {
        html = html +
                "<li>" +
                "Player " + playerNumber + " - moves at coordinates " + x + ", " + y +
                "</li>";
    }

    public String printHtml() {
        html = html + "</ul>" +
                "</body>\n" +
                "</html>";
        return html;
    }
}
