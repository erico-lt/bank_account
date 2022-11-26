package entites.accounts;

import entites.AccountManagement;
import enums.Type;

public class EasyAccount extends AccountManagement{

    public EasyAccount(Integer accountNum, String name, Type type, String email) {
        super(accountNum, name, type, email);       
    }

    @Override
    public void deposit(double depositValue) {
        if(!validDeposit(this.getType(), this.getBalance(), depositValue)) {
            //Exceção para tratamento de possivel erro de deposito
            throw new AccountException("Tipo da conta incompativel com o deposito \n verfique se o saldo não está no limite");            
        } else {
            this.setBalance(this.getBalance() + depositValue);
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
