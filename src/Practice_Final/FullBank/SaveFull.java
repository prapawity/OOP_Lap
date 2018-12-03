package Practice_Final.FullBank;

import Practice_Final.ListAccount;
import Practice_Final.MyAccount;

import java.io.*;
import java.util.ArrayList;

public class SaveFull {
    public static void write(ArrayList<AccountBank> acount){
        try {
            FileOutputStream fos = new FileOutputStream("output2.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(acount);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void read(File file) throws Exception{
        FileInputStream fin;
        ObjectInputStream oin;
        fin = new FileInputStream(file.getName());
        oin = new ObjectInputStream(fin);
        ArrayOfaccount.listAccountBank = (ArrayList<AccountBank>) oin.readObject();
        oin.close();
        fin.close();
    }
}
