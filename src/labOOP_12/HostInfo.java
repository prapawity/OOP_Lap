package labOOP_12;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo {
    public static void main(String[] args) {

        try {
            InetAddress myHost = InetAddress.getLocalHost();
            System.out.println("Name: " + myHost.getHostName());
            System.out.println("IP: " + myHost.getHostAddress());
        } catch (
                UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
