package labOOP_12;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            HelloJava obj = new HelloJava();
            Naming.rebind("hello", obj);

        } catch (Exception e) {
            e.printStackTrace(); }
    }
}
