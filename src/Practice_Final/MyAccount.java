package Practice_Final;

import java.io.Serializable;

public class MyAccount implements Serializable {
    String name;
    protected double balance = 0;
    public MyAccount(String name){
        this.name = name;
    }

    public void deposite(double deposite){
        balance+=deposite;

    }
    public void withDraw(double withDraw){
        balance-=withDraw;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
