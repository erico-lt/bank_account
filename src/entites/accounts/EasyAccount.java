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
            throw new AccountException("Tipo da conta incompativel para o deposito, verfique se o saldo não atingiu seu limite");            
        } else {
            this.setBalance(this.getBalance() + depositValue);
        }              
    }

    @Override
    public double withDraw(double withDrawValue) {
        if(!validWithDrawn(getType(), this.getBalance(), withDrawValue)) {
            throw new AccountException("Por favor confira se o tipo da conta é legivel para saque desta quantia, e verifique o saldo, seguido do horario");
        } else {
            this.setBalance(this.getBalance() - withDrawValue);
        }
        return withDrawValue;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
