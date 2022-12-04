package entites.bank;

import java.util.ArrayList;
import java.util.List;

import entites.Account;
import entites.AccountManagement;

public class Bank {
    private String name = "Brazil of Bank";
    protected List<Account> listAccounts = new ArrayList<Account>();    

    public Bank(){        
    }

    public Bank(String name) {
        this.setName(name);
    }    

    public void removeAccount (AccountManagement account, List<Account> list) {
        if(!accountExiste(account, list)){
            throw new BankException("Essa conta não existe por favor tente novamente");
        }
        if(account.getBalance() > 0) {
            throw new BankException("A conta ainda possui valor em caixa, por favor faça um deposito:");
        }
        account.setStatus(false);        
        listAccounts.remove(account);                   
    }

    // Posteriormente deve ser criado uma pesquisa binaria, caso a lista estiver muito grande
    public AccountManagement searchAccount(List<Account> listAccount, String name, Integer numAccount) {
        AccountManagement aux = (AccountManagement)listAccount.stream().filter(x -> x.getName().equals(name) && x.getAccountNum().equals(numAccount)).findFirst().orElse(null);
        if(aux == null) {
            throw new BankException("Está conta não existe, por favor tente outra!");
        }
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

    public String accounts() {
        StringBuilder stb = new StringBuilder();
        for(Account x: listAccounts) {
            stb.append(x.toString());     
        }
        return stb.toString();
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
