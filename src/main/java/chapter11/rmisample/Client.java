package chapter11.rmisample;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {}
    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            MyRemote stub = (MyRemote) registry.lookup("RemoteHello");

            // Calling the remote method using the obtained object
            String ret = stub.sayHello();
            System.out.println("client result: " + ret);

             System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}