package com.compulsory;

public class Socket extends Thread {
    private Object GameClient;

    public void run() {
        GameClient = new GameClient();
    }
}
