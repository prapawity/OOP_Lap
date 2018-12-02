package Practice_Final;

import labOOP_10.GetSaveNotepad;

import java.io.*;
import java.util.ArrayList;

public class Save{
    public static void write(ArrayList<MyAccount> acount){
        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acount);
            System.out.println("Success");
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read() throws Exception{
        FileInputStream fin;
        ObjectInputStream oin;
        fin = new FileInputStream("output.txt");
        oin = new ObjectInputStream(fin);
        ListAccount.listMyAccount = (ArrayList<MyAccount>) oin.readObject();
        System.out.println(ListAccount.getAccount(0).getName());
        oin.close();
        fin.close();
    }

    public static void main(String[] args) {
        try {
            read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
