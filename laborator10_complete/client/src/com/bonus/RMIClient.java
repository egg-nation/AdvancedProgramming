package com.bonus;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class RMIClient {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost");
        RMIInterface rmi = (RMIInterface) registry.lookup("Message");
        String message = rmi.sendMessage("create game");
        System.out.println(message);

    }
}
