package labOOP_12;

import java.net.ServerSocket;
import java.net.Socket;

public class FileThreadServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(5050); while (true) {
                System.out.println("Waiting for client.."); Socket s = ss.accept();
                ThreadHandler th = new ThreadHandler(s); Thread t = new Thread(th);
                t.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace(); }
    }
}
