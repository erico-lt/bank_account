package entites.accounTypes;

import entites.AccountManagement;
import enums.Type;

public class EasyAccount extends AccountManagement{

    public EasyAccount(Integer accountNum, String name, Type type, String email) {
        super(accountNum, name, type, email);       
    }

    @Override
    public void deposit(double depositValue) {
        if(!validDeposit(this.getType(), this.getBalance())) {
            //Criar exceção para tratamento de possivel erro de deposito
        }              
    }

    @Override
    public double withDraw(double withDrawValue) {
        
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
