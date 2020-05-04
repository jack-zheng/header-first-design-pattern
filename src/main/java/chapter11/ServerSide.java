package chapter11;

import chapter11.rmisample.MyRemote;
import chapter11.rmisample.MyRemoteImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerSide {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        GumballMachineRemote machineRemote = new GumballMachine("shanghai", 5);
        GumballMachineRemote stub = (GumballMachineRemote) UnicastRemoteObject.exportObject(machineRemote, 0);
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("GumballServer", stub);
        System.out.println("Server ready...");
    }
}
