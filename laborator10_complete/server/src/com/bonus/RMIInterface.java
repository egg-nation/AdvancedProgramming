package com.bonus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    String sendMessage (String message) throws RemoteException;
}
