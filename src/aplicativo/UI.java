package aplicativo;

import java.util.List;
import java.util.Scanner;

import entites.Account;
import entites.accounts.CurrentAccount;
import entites.accounts.EasyAccount;
import entites.accounts.SavingAccount;
import entites.bank.Bank;
import enums.Type;

public class UI {    
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public static void initial(Bank bank) {
        System.out.println("Bank Name: " + bank.getName());
        System.out.println(",________,\n"
                      + "/_\\______\\ \n"+
                        "|_|______|"); 
        System.out.println();                
    }

    public static Integer opcaoesAtendimento(Scanner sc) {         
        System.out.println();        
        System.out.println("     ╔═══════════╗ \n"+ 
                           "         MENU      \n" +         
                           "     ╚═══════════╝");
        
        System.out.println("[1] para abrir conta");
        System.out.println("[2] para acessar conta");
        System.out.println("[3] para fechamento de conta");   
        System.out.println();     
        System.out.println("Digite uma opcao: ");
        Integer opcao =  sc.nextInt();        
        return opcao;        
    }

    public static void printNumsUseds(List<Account> listAccouts) {
        System.out.print("Numeros ja usados: ");
        for(Account x: listAccouts) {
            System.out.print(x.getAccountNum() + ",");
        }
        System.out.println();
    }    

    public static void selecopcao(int opcao,Scanner sc, Bank bank) {        
        switch(opcao) {            
            case 1:
                sc.nextLine();
                System.out.print("Digite seu nome: ");                
                String name = sc.nextLine();                                    
                printNumsUseds(bank.getListAccounts()); 
                System.out.print("Digite o numero da conta: ");                            
                int numAccount = (Integer) sc.nextInt();                  
                System.out.print("Escolha o tipo da conta [EASYACCOUNT,SAVINGACCOUNT,CURRENTACCOUNT]:");              
                Type type = Type.valueOf(sc.next()); 
                System.out.print("Digite seu email: ");
                String email = sc.next();
                if(type == Type.EASYACCOUNT) {
                    bank.addNewAccount(new EasyAccount(numAccount, name, type, email));
                } else if(type == Type.SAVINGACCOUNT) {
                    bank.addNewAccount(new SavingAccount(numAccount, name, type, email));
                } else {
                    bank.addNewAccount(new CurrentAccount(numAccount, name, type, email));
                }
            case 2:    
                System.out.println();
            default:                 
                break;                
        }        
    }
    
    
}
