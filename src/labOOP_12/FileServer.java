package labOOP_12;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

                public static void main (String[]args){
                    try {
                        ServerSocket ss = new ServerSocket(5050);
                        while (true) {
                            System.out.println("Waiting for client..");
                            Socket s = ss.accept();
                            InputStream in = s.getInputStream();
                            DataInputStream din = new DataInputStream(in);
                            String fileName = din.readUTF();
                            FileInputStream fin = new FileInputStream(fileName);
                            OutputStream out = s.getOutputStream();
                            byte[] b = new byte[1024];
                            int i;
                            while ((i = fin.read(b)) != -1) {
                                out.write(b);
                            }
                            out.close();
                            fin.close();
                            din.close();
                            s.close();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }