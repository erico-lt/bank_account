package entites.accounts;

import entites.bank.BankException;

public class AccountException extends BankException{
    public AccountException(String msg) {
        super(msg);
    }
    
}
