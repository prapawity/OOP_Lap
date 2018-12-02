package labOOP_12;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloJava extends UnicastRemoteObject implements Hello{

    public HelloJava() throws RemoteException { }
    public String sayHello() throws RemoteException { return "60070045";


}
}
