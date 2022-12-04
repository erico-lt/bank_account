package aplicativo;

import java.util.InputMismatchException;
import java.util.Scanner;

import entites.accounts.EasyAccount;
import entites.bank.Bank;
import entites.bank.BankException;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception { 
      Scanner sc = new Scanner(System.in);
      Bank bank = new Bank(); 
      boolean continuE = true;   
      EasyAccount account = new EasyAccount(321, "ERICO", Type.EASYACCOUNT,"erico.blp@gmail.com");  
      bank.addNewAccount(account);  

      while(continuE == true) {
        UI.clearScreen(); 

        try {          
          UI.initial(bank);          
          System.out.println("Escolha uma opcao para melhorar o atendimento");                        
          int opcao = UI.opcaoesAtendimento(sc);
          UI.selecopcao(opcao, sc, bank);           
        }catch(BankException e) {
          System.out.println("Erro " + e.getMessage());
          sc.nextLine();
        }catch(InputMismatchException e){
          System.out.println("Erro de dado " + e.getMessage());  
          sc.nextLine();      
        }
        
        System.out.println(bank.accounts());
        System.out.print("Deseja mais algum atendimento[Yes/No]:");
        String resp = sc.next();
        if(resp.equals("Yes") || resp.equals("yes")){
          continuE = true;
        } else {
          continuE = false;
        }       
        
      }
    }
}
