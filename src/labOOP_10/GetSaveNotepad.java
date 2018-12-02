package labOOP_10;

import javax.swing.*;
import java.io.*;

public class GetSaveNotepad {
    private  static String balance;

    public static String getBalance(String name){

        try (FileInputStream fin = new FileInputStream(name);
             DataInputStream din = new DataInputStream(fin)){
            balance = din.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public static void saveBalance(String balance,String name) {

            try (FileOutputStream fout = new FileOutputStream(name);
                 DataOutputStream dout = new DataOutputStream(fout)) {
                dout.writeUTF(balance);
            } catch (IOException e) {
                e.printStackTrace();
            }

        GetSaveNotepad.balance = balance;
    }
    public static void saveBalance2(String balance,String name) {

        try (FileOutputStream fout = new FileOutputStream( name+".txt");
             DataOutputStream dout = new DataOutputStream(fout)) {
            dout.writeUTF(balance);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GetSaveNotepad.balance = balance;
    }
}
