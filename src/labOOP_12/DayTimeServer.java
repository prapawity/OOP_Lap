package labOOP_12;

import java.io.IOException;
import java.net.ServerSocket;

public class DayTimeServer {
    public static void main(String[] args) {
        try {
            try {
                ServerSocket ss = new ServerSocket(5050);
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (true) {
                System.out.println("Waiting for client..");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}