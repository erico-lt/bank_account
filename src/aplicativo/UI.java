package aplicativo;

import java.util.Scanner;

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

    public static void opcaoesAtendimento() {         
        System.out.println();        
        System.out.println("     ╔═══════════╗ \n"+ 
                           "         MENU\n" +         
                           "     ╚═══════════╝");
        
        System.out.println("[1] para abrir conta");
        System.out.println("[2] para acessar conta");
        System.out.println("[3] para fechamento de conta");   
        System.out.println();     
    }

    public static void selecopcao(int opcao, Scanner sc) {
        switch(opcao) {
            case 1:
                System.out.println("Digite seu nome: ");
                String name = sc.nextLine();
                //Criar uma lista dos numeros de contas já usados
                System.out.println("");
            case 2:    
                System.out.println();
        }
    }
    
}
