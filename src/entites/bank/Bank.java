package entites.bank;

import java.util.ArrayList;
import java.util.List;

import entites.Account;
import entites.AccountManagement;

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

    public void removeAccount (String name, int numAccount) {
        AccountManagement aux = (AccountManagement)searchAccount(this.listAccounts, name, numAccount);
        if (aux == null){
            throw new BankException("Essa conta não existe por favor tente novamente");
        } else {
            aux.setStatus(false);
            listAccounts.remove(aux);            
        }
        
    }

    // Posteriormente deve ser criado uma pesquisa binaria, caso a lista estiver muito grande
    public Account searchAccount(List<Account> listAccount, String name, int numAccount) {
        Account aux = listAccount.stream().filter(x -> x.getName() == name && x.getAccountNum() == numAccount).findFirst().orElse(null);
        return aux;
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
