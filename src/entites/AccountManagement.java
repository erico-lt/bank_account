package entites;

import enums.Type;

public abstract class AccountManagement extends Account{
    private String email;
    private Type type;    

    public AccountManagement(Integer accountNum, String name, Type type) {
        super(accountNum, name);
        this.setType(type);
    }  

    public double validType(Type type) {
        if(type.equals(Type.EASYACCOUNT)) return 10.00;            
        if(type.equals(Type.SAVINGACCOUNT)) return 30.00; 
        return 50.00;      
    }

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
}