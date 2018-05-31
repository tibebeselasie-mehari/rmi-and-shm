package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRMIDemo extends Remote{
    public String doCommunicate(String name) throws RemoteException;
}
