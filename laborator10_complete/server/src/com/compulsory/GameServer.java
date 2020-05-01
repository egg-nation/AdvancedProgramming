package com.compulsory;

import com.optional.Game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private boolean isRunning = true;
    private static final int PORT = 8100;
    private List<Game> games;

        public GameServer() throws IOException {
            games = new ArrayList<>();
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(PORT);
                while (isRunning) {
                    System.out.println("Waiting for a client ...");
                    Socket socket = serverSocket.accept(); // Server is listening
                    new ClientThread(socket, this).start(); // A client accept a TCP communication
                }
            } catch (IOException e) {
                System.err.println("Ooops... " + e);
            } finally {
                System.out.println("Server closed");
                serverSocket.close();
            }
        }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
