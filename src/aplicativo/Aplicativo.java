package aplicativo;

import java.util.InputMismatchException;
import java.util.Scanner;
import entites.bank.Bank;

public class Aplicativo {
    public static void main(String[] args) throws Exception { 
      Scanner sc = new Scanner(System.in);
      Bank bank = new Bank();
      while(true) {
        UI.clearScreen(); 
        try {
          UI.initial(bank);
          System.out.println("Escolha uma opcao para melhorar o atendimento");   
          UI.opcaoesAtendimento();   
          System.out.println("Digite uma opcao: ");
          UI.selecopcao(sc.nextInt(), sc);         
        
        } catch(RuntimeException e){
          throw new InputMismatchException("Erro os dados passados são invalidos valores aceitos de 1 ate 3");        
        } finally {
          sc.close();
        }  
      } 
      
    }
}
