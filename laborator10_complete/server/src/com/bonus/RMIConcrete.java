package com.bonus;
import java.rmi.RemoteException;

public class RMIConcrete implements RMIInterface {

    public RMIConcrete () throws RemoteException{
        super();
    }

    @Override
    public String sendMessage(String message) throws RemoteException{
        return "Server received the request ..." + message;
    }


}
