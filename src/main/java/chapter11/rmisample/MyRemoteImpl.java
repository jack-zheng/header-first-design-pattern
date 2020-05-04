package chapter11.rmisample;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl implements MyRemote {
    public MyRemoteImpl() {
    }

    @Override
    public String sayHello() {
        return "Server says 'Hey'";
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
//        MyRemote service = new MyRemoteImpl();
//        Naming.rebind("RemoteHello", service);
        MyRemote obj = new MyRemoteImpl();
        MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(obj, 0);
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("RemoteHello", stub);
        System.out.println("Server ready...");
    }
}
