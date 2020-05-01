package com.compulsory;

import com.bonus.GomokuApp;

import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class GameClient {
    private String serverAddress = "127.0.0.1";
    private boolean isRunning = true;

    public GameClient() {
        try (
                Socket socket = new Socket(serverAddress, 8100);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in)) {
            while (isRunning) {
                makeRequests(scan, out, in);
            }
        } catch (IOException e) {
            System.err.println("No server listening... " + e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void responseToCommand(BufferedReader in) throws IOException {
        String response = in.readLine();
        System.out.println(response);

        if (Objects.equals(response, "Server stopped")) {
            isRunning = false;
        }
        else if (Objects.equals(response, "Game created")) {
            GomokuApp.setBoard(8);
        }
        else if (Objects.equals(response, "Game created")) {
            GomokuApp.setBoard(8);
        }
    }

    private void updateBoard(BufferedReader in) throws IOException {
        String row = in.readLine();
        String col = in.readLine();
        System.out.println(row + " " + col);
        GomokuApp.setMoves(row, col);
    }

    private void submitMove(PrintWriter out) {
        String response = GomokuApp.getCoordinates("X");
        System.out.println(response);
        out.println(response);
        response = GomokuApp.getCoordinates("Y");
        System.out.println(response);
        out.println(response);
    }


    private void checkWinner(BufferedReader in) throws IOException {
        String response = in.readLine();

        if (response.compareTo("winner") > 0) {
            String winner = in.readLine();
            System.out.println(winner);
            GomokuApp.printWinner(winner);
        }
    }

    private void updateBoard(BufferedReader in) throws IOException {
        String row = in.readLine();
        String col = in.readLine();
        System.out.println(row + " " + col);
        GomokuApp.setMoves(row, col);
    }

    private void makeRequests(Scanner scan, PrintWriter out, BufferedReader in) throws IOException {
        String req = sendRequest(scan, out);

        if (Objects.equals(req, "exit")) {
            isRunning = false;
        }
        else if ((Objects.equals(req, "win"))) {
            checkWinner(in);
        }
        else if ((Objects.equals(req, "submit move"))) {
            submitMove(out);
        }
        else if ((Objects.equals(req, "update"))) {
            updateBoard(in);
        }
        else {
            responseToCommand(in);
        }
    }
}
