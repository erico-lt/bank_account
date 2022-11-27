package aplicativo;

import entites.accounts.SavingAccount;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception {
       SavingAccount account = new SavingAccount(8533, "Erico", Type.EASYACCOUNT,"erico.blp@gmail.com");  
       account.deposit(1990.00);
       System.out.println(account.toString()); 
       System.out.println();
       System.out.println();
       double valorRecebido = account.withDraw(50);
       System.out.println(account.toString());
       System.out.println("Valor recebido: " + valorRecebido);         
    }
}
