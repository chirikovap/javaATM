package interaction;

import java.util.ArrayList;

public class Transaction {
    public static ArrayList <String> allTransactions = new ArrayList<String>();

    public static String getTransactions() {
        for (int i = 0; i < allTransactions.size(); i++) {
            System.out.println(allTransactions.get(i));
        }
        return null;
    }
}
