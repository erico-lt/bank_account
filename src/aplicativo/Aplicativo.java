package aplicativo;

import java.util.InputMismatchException;
import java.util.Scanner;
import entites.bank.Bank;

public class Aplicativo {
    public static void main(String[] args) throws Exception { 
      Scanner sc = new Scanner(System.in);
      Bank bank = new Bank(); 
      boolean continuE = true;       

      while(continuE == true) {
        UI.clearScreen(); 

        try {          
          UI.initial(bank);          
          System.out.println("Escolha uma opcao para melhorar o atendimento");                        
          int opcao = UI.opcaoesAtendimento(sc);
          UI.selecopcao(opcao, sc, bank);           
        } catch(RuntimeException e){
          throw new InputMismatchException("Erro os dados passados são invalidos");        
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
