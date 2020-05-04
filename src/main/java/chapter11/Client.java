package chapter11;

import chapter11.rmisample.MyRemote;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private Client() {
    }

    public static void main(String[] args) {
        try {
            // Getting the registry
            Registry registry = LocateRegistry.getRegistry(null);

            // Looking up the registry for the remote object
            GumballMachineRemote stub = (GumballMachineRemote) registry.lookup("GumballServer");

            // Calling the remote method using the obtained object
            System.out.println(String.format("client result: [Location | count | state] - [%s | %s | %s]", stub.getLocation(), stub.getCount(), stub.getState()));

            System.out.println("Remote method invoked");
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}