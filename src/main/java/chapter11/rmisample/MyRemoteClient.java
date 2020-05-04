package chapter11.rmisample;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyRemoteClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        new MyRemoteClient().go();
    }

    public void go() throws RemoteException, NotBoundException, MalformedURLException {
        MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
        String s = service.sayHello();
        System.out.println(s);
    }
}
