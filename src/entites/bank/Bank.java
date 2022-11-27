package entites.bank;

import java.util.ArrayList;
import java.util.List;

import entites.Account;

public class Bank {
    private String name = "Brazil of Bank";
    List<Account> listAccounts = new ArrayList<Account>();

    public Bank(){        
    }

    public Bank(String name) {
        this.setName(name);
    }    

    public String getName() {
        return name;
    }
    
    private void setName(String name) {
        this.name = name;
    }

    public void addNewAccount (Account account) {
        this.listAccounts.add(account);
    }

    public void accounts() {
        for(Account x: listAccounts) {
            System.out.println(x.toString());
            System.out.println();
            System.out.println();
        }
    }

}
