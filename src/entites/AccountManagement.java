package entites;

import enums.Type;

public abstract class AccountManagement extends Account{
    private String email;
    private Type type;    

    public AccountManagement(Integer accountNum, String name, Type type, String email) {
        super(accountNum, name);
        this.setType(type);
        this.setEmail(email);
        bonusOpenAccount(validType(this.getType())) ;
    }  

    //metodo para validar o tipo da conta
    private double validType(Type type) {
        if(type.equals(Type.EASYACCOUNT)) return 10.00;            
        if(type.equals(Type.SAVINGACCOUNT)) return 30.00; 
        return 50.00;      
    }

    private void bonusOpenAccount(double bonus) {
        this.balance = bonus;
    }

    public boolean validDeposit(Type type, double balance) {
        if (type == Type.EASYACCOUNT && balance < 2000.00) return true;
        if(type == Type.SAVINGACCOUNT && balance < 4000.00) return true;
        if(type == Type.CURRENTACCOUNT) return true;
        return false;
    }

    //Metodos acessores e modificadores
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("Email: " + this.getEmail());
        return super.toString() + stb.toString();
    }
}