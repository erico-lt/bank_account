package aplicativo;

import java.util.InputMismatchException;
import java.util.Scanner;

import entites.accounts.EasyAccount;
import entites.bank.Bank;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception { 
      Scanner sc = new Scanner(System.in);
      Bank bank = new Bank();   
      EasyAccount account = new EasyAccount(45423, "Erico", Type.EASYACCOUNT, "erico.blp@gmail.com");
      bank.addNewAccount(account);
      
      while(true) {
        UI.clearScreen(); 
        try {          
          UI.initial(bank);
          System.out.println("Escolha uma opcao para melhorar o atendimento");                        
          int opcao = UI.opcaoesAtendimento(sc);
          UI.selecopcao(opcao, sc, bank);           
        } catch(RuntimeException e){
          throw new InputMismatchException("Erro os dados passados são invalidos");        
        }finally {
          sc.close();
        }  
      }
      
    }
}
