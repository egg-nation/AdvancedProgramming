package com.compulsory;

import com.optional.Game;

import java.io.*;
import java.util.Objects;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private boolean clientIsRunning = true;
    private Game game;
    private int numberPlayer;
    private GameServer gameServer;

    public ClientThread(Socket socket, GameServer gameServer) {
        this.socket = socket;
        this.gameServer = gameServer;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (gameServer.isRunning() && clientIsRunning) { // the Game Loop
                executeCommands(in, out);
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Finished with client");
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

    private void unknownRequest(PrintWriter out) {
        String response = "Server received the request ... ";
        out.println(response);
        out.flush();
    }

    private void checkWinner(PrintWriter out) throws IOException {
        if (game.checkWinner()) {
            sendResponse("winner", out);
            sendResponse(String.valueOf(game.getCurrPlayer().getNumber()), out);
            FileWriter myWriter = new FileWriter("reportGame.html");
            myWriter.write(game.getHtmlReport().printHtml());
            myWriter.close();

            ScpCommand.execute();
        }
        sendResponse("Game is not finished", out);
    }

    private void updateBoard(PrintWriter out) {
        System.out.println(game.getLastMove().getPosX());
        System.out.println(game.getLastMove().getPosY());

        sendResponse(game.getLastMove().getPosX(), out);
        sendResponse(game.getLastMove().getPosY(), out);
    }

    private void submitMove(BufferedReader in) throws IOException {
        String row = in.readLine();
        String col = in.readLine();

        System.out.println(row);
        System.out.println(col);

        game.putPiece(row, col);
    }

    private void joinGame(PrintWriter out) {
        if (this.game == null) {
            this.game = gameServer.getGames().get(0);
            gameServer.getGames().remove(0);
            sendResponse("You joined a game", out);
            numberPlayer = 2;
        }
        else {
            sendResponse("You already are in a game", out);
        }
    }

    private void createGame(PrintWriter out) {
        if (this.game == null) {
            Game game = new Game(8);
            gameServer.getGames().add(game);
            this.game = game;
            numberPlayer = 1;
            sendResponse("Game created", out);
        }
        else {
            sendResponse("You already are in a game", out);
        }
    }

    private void executeCommands( BufferedReader in, PrintWriter out) throws IOException {
        String request = readRequest(in);
        if (Objects.equals(request, "exit")) {
            clientIsRunning = false;
        }
        else if (Objects.equals(request, "stop")) {
            gameServer.setRunning(false);
            sendResponse("Server stopped", out);
        }
        else if (Objects.equals(request, "win")) {
            checkWinner(out);
        }
        else if (Objects.equals(request, "create game")) {
            createGame(out);
        }
        else if (Objects.equals(request, "update")) {
            updateBoard(out);
        }
        else if (Objects.equals(request, "join game")) {
            joinGame(out);
        }
        else if (Objects.equals(request, "submit move")) {
            submitMove(in);
        }
        else {
            unknownRequest(out);
        }
    }

    private String readRequest(BufferedReader in) throws IOException {
        String request = in.readLine();
        System.out.println(request);

        return request;
    }

    private void sendResponse(String message, PrintWriter out) {
        out.println(message);
        out.flush();
    }
}
