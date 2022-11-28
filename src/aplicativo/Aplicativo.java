package aplicativo;

import entites.accounts.EasyAccount;
import entites.accounts.SavingAccount;
import entites.bank.Bank;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception {
       SavingAccount account = new SavingAccount(8533, "Erico", Type.SAVINGACCOUNT,"erico.blp@gmail.com");         
       SavingAccount account2 = new SavingAccount(8533, "Erico", Type.SAVINGACCOUNT,"erico.blp@gmail.com");       
       EasyAccount account3 = new EasyAccount(853, "Erico Santana", Type.EASYACCOUNT,"erico.blp@gmail.com");

       Bank bank = new Bank();       
       bank.addNewAccount(account);
       bank.addNewAccount(account2);
       bank.addNewAccount(account3);       

       System.out.println("Bank Name: " + bank.getName());
       System.out.println(",________,\n"
                        + "/_\\______\\ \n"+
                          "|_|______|");
       System.out.println();                   
       bank.accounts(); 
       System.out.println();
       System.out.println("======================================");

       bank.removeAccount("Erico Santana", 853);
       System.out.println("Bank Name: " + bank.getName());
       bank.accounts(); 
               
    }
}
