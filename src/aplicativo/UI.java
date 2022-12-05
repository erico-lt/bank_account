package aplicativo;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entites.Account;
import entites.AccountManagement;
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
        System.out.println();     
        System.out.print("Digite uma opcao: ");
        Integer opcao =  sc.nextInt();
        if((opcao != 1) && (opcao != 2)) {
            throw new InputMismatchException("Problemas com dados passados, valores aceitos de 1 ate 3");
        }       
        System.out.println(); 
        return opcao;        
    }

    public static Integer accountOptions(Scanner sc) {                
        System.out.println();        
        System.out.println("     ╔═══════════╗ \n"+ 
                           "         OPÇÕES    \n" +         
                           "     ╚═══════════╝");
        
        System.out.println("[1] depositio");
        System.out.println("[2] saque");
        System.out.println("[3] para fechamento de conta");   
        System.out.println();     
        System.out.print("Digite uma opcao: ");
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
                System.out.println("BEM VIANDO AO PROCEDIMENTO PARA ABRIR CONTA");
                System.out.println();
                System.out.print("Digite seu nome: ");                
                String name = sc.nextLine().toUpperCase();                                    
                printNumsUseds(bank.getListAccounts()); 
                System.out.print("Digite o numero da conta: ");                            
                Integer numAccount =  sc.nextInt();                  
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
                break;
            case 2:    
                sc.nextLine();
                System.out.println("BEM VIANDO AO PROCEDIMENTO PARA ACESSO A CONTA");
                System.out.println();
                System.out.print("Digite seu nome: ");                
                name = sc.nextLine().toUpperCase();                  
                System.out.print("Digite o numero da conta: ");                            
                numAccount =  sc.nextInt(); 
                AccountManagement managementAccount = bank.searchAccount(bank.getListAccounts(), name, numAccount);
                Integer selectOption = accountOptions(sc);
                if(selectOption.equals(1)) {
                    System.out.print("Digite o valor para deposito: ");                    
                    managementAccount.deposit(sc.nextDouble());
                    System.out.println();
                }else if(selectOption.equals(2)) {
                    System.out.print("Digite o valor para saque: ");
                    managementAccount.withDraw(sc.nextDouble());
                    System.out.println();
                }else {
                  bank.removeAccount(managementAccount, bank.getListAccounts());  
                }                                    
                break;
            default:                 
                break;                
        }        
    }
    
    
}
