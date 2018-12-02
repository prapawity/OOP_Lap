package Practice_Final;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAccount implements Serializable {
    static ArrayList<MyAccount> listMyAccount = new ArrayList<>();

    public static void addAccount(MyAccount account){
        listMyAccount.add(account);
    }
    public static MyAccount getAccount(int index){
        return listMyAccount.get(index);
    }
    public static ArrayList<MyAccount> allAccount(){
        return listMyAccount;

    }
}
