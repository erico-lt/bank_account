package aplicativo;

import entites.accounts.EasyAccount;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception {
       EasyAccount account = new EasyAccount(8533, "Erico", Type.EASYACCOUNT,"erico.blp@gmail.com");  
       account.deposit(1990.00);
       System.out.println(account.toString()); 
       double valorRecebido = account.withDraw(2000.00);
       System.out.println(account.toString());
       System.out.println("Valor recebido: " + valorRecebido);         
    }
}
