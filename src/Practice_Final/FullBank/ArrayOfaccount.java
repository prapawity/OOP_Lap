package Practice_Final.FullBank;

import Practice_Final.MyAccount;

import java.io.Serializable;
import java.util.ArrayList;

public class ArrayOfaccount implements Serializable {
    static ArrayList<AccountBank> listAccountBank = new ArrayList<>();
    public static void addAccount(AccountBank account){
        listAccountBank.add(account);
    }
    public static AccountBank getAccount(int index){
        return listAccountBank.get(index);
    }
    public static ArrayList<AccountBank> allAccount(){
        return listAccountBank;

    }


}
