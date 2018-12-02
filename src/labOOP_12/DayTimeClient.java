package labOOP_12;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 5050);
             InputStream in = s.getInputStream();
             DataInputStream din = new DataInputStream(in)) { System.out.println(din.readUTF());
        } catch (Exception ex) { ex.printStackTrace();
        } }

}