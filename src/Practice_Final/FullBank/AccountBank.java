package Practice_Final.FullBank;

import java.io.Serializable;
import java.util.ArrayList;

public class AccountBank implements Serializable {
    private String name;
    private double balance;
    int k = 0;
    private ArrayList<String> log = new ArrayList<>(50);
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public String getLog(int index) {
        return log.get(index);
    }
    public ArrayList<String> getlog(){
        return log;
    }

    public void setLog(String word, int index) {
        String output = "";
        if(k==0){
            output = word+"\n";
            k++;
            for (int k=0;k<50;k++) log.add("");
        }
        else output = log.get(index) + word + "\n";
        log.set(index, output);
    }

    public AccountBank(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }


}
