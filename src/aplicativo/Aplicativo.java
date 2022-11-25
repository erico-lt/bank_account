package aplicativo;

import entites.accounTypes.EasyAccount;
import enums.Type;

public class Aplicativo {
    public static void main(String[] args) throws Exception {
       EasyAccount account = new EasyAccount(8533, "Erico", Type.EASYACCOUNT,"erico.blp@gmail.com");  
       System.out.println(account.toString());      
       
    }
}
