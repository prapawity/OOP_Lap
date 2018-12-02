package labOOP_12;

import java.rmi.Naming;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Hello obj = (Hello) Naming.lookup("rmi://"+"10.72.1.10"+"/hello");
            System.out.println(obj.sayHello()); } catch (Exception e) {
            e.printStackTrace(); }
    }
}
