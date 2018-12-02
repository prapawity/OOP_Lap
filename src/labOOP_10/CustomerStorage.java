package labOOP_10;

import labOOP_7.TellerGUI;
import labOOP_8.Customer;

import java.io.*;

public class CustomerStorage {
    private  static double balance;

    public static double getBalance(){

        try (FileInputStream fin = new FileInputStream("Customer.dat");
             DataInputStream din = new DataInputStream(fin)){
            balance = din.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return balance;
    }

    public static void saveBalance(double balance) {
        try (FileOutputStream fout = new FileOutputStream("Customer.dat");
             DataOutputStream dout = new DataOutputStream(fout)){
            dout.writeDouble(balance);
        } catch (IOException e) {
            e.printStackTrace();
        }
        CustomerStorage.balance = balance;
    }
}
