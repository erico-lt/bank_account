package aplicativo;

import java.util.List;
import java.util.Scanner;

import entites.Account;
import entites.bank.Bank;

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
        for(Account x: listAccouts) {
            System.out.print(x.getAccountNum() + ",");
        }
    }    

    public static void selecopcao(int opcao,Scanner sc, Bank bank) {        
        switch(opcao) {            
            case 1:
                sc.nextLine();
                System.out.println("Digite seu nome: ");                
                String name = sc.nextLine(); 
                System.out.println();               
                System.out.print("Numeros ja usados: ");
                printNumsUseds(bank.getListAccounts()); 
                System.out.println("Digite o numero da conta");                            
                int numAccount = (Integer) sc.nextInt();                  
                              
            case 2:    
                System.out.println();
            default:                 
                break;                
        } 
        
    }
    
    
}
