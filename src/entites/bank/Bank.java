package entites.bank;

import java.util.ArrayList;
import java.util.List;

import entites.Account;
import entites.AccountManagement;

public class Bank {
    private String name = "Brazil of Bank";
    public List<Account> listAccounts = new ArrayList<Account>();

    public Bank(){        
    }

    public Bank(String name) {
        this.setName(name);
    }    

    public void removeAccount (String name, int numAccount) {
        AccountManagement aux = (AccountManagement)searchAccount(this.listAccounts, name, numAccount);
        if (aux == null){
            throw new BankException("Essa conta não existe por favor tente novamente");
        } 
        aux.setStatus(false);
        listAccounts.remove(aux);            
    }

    // Posteriormente deve ser criado uma pesquisa binaria, caso a lista estiver muito grande
    public Account searchAccount(List<Account> listAccount, String name, int numAccount) {
        Account aux = listAccount.stream().filter(x -> x.getName() == name && x.getAccountNum() == numAccount).findFirst().orElse(null);
        return aux;
    }    

    public void addNewAccount (Account account) {
        if(accountExiste(account, this.listAccounts)) {
            throw new BankException("Conta já existente, ou dados por favor tente novamente");
        }
        this.listAccounts.add(account);
    }

    public boolean accountExiste(Account account,List<Account> listAccount) {
        Account aux = listAccount.stream().filter(x -> x.getName().equals(account.getName()) && x.getAccountNum().equals(account.getAccountNum()) || x.getAccountNum().equals(account.getAccountNum())).findFirst().orElse(null);
        if(aux != null) {
            return true;
        }
        return false;
    }      

    public void accounts() {
        for(Account x: listAccounts) {
            System.out.println(x.toString());
            System.out.println();            
        }
    }

    public String getName() {
        return name;
    }
    
    private void setName(String name) {
        this.name = name;
    }

    public List<Account> getListAccounts() {
        return this.listAccounts;
    }

}
