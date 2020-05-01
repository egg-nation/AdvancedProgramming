package com.bonus;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args) throws Exception{
        RMIInterface rmi = new RMIConcrete();
        RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(rmi, 0);
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Message", stub);
        System.out.println("Server active");
    }
}
