package com.company;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


class RMIServer extends UnicastRemoteObject implements IRMIDemo{

    private static final long serialVersionUI = 1L;

    protected RMIServer() throws RemoteException{
        super();
    }


    @Override
    public String doCommunicate(String name) throws RemoteException {
        return "\nServer says : Hi " + name +"\n";
    }
}

public class Main {

    public static void main(String[] args) throws Exception{
	    RMIServer server = new RMIServer();
        Naming.bind("RMIExample", server);
        System.out.println("the object is bound and is ready...");
        String serverName = "";
        String uri = new String("rmi://"+serverName+"/RMIExample");
        RMIServer server1 = (RMIServer) Naming.lookup(uri);
        String reply = server1.doCommunicate("sadfdsaf");
        System.out.println("result : " + reply);
    }
}
