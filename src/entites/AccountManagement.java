package entites;

import java.text.SimpleDateFormat;
import java.util.Date;

import enums.Type;

public abstract class AccountManagement extends Account{
    private String email;
    private Type type;   
    private boolean status; 

    public AccountManagement(Integer accountNum, String name, Type type, String email) {
        super(accountNum, name);
        this.setType(type);
        this.setEmail(email);
        this.setStatus(true);
        bonusOpenAccount(validType(this.getType())) ;
    }  

    //metodo que retorna um valor que será adicionado no saldo da conta na sua abertura de acordo com seu tipo
    private double validType(Type type) {
        if(type.equals(Type.EASYACCOUNT)) return 10.00;            
        if(type.equals(Type.SAVINGACCOUNT)) return 30.00; 
        return 50.00;      
    }

    //metodo que adiciona o bonus de acordo com o tipo da conta
    private void bonusOpenAccount(double bonus) {
        this.balance = bonus;
    }

    //metodo para validar o deposito de acordo com o tipo da conta
    public boolean validDeposit(Type type, double balance, double depositValue) {              
        if (type == Type.EASYACCOUNT && (balance + depositValue <= 2000.00) && this.getStatus() == true) return true;
        if(type == Type.SAVINGACCOUNT && (balance + depositValue <= 4000.00) && this.getStatus() == true) return true;
        if(type == Type.CURRENTACCOUNT && this.getStatus()) return true;
        return false;
    }
    
    public boolean validDeposit(Type type) {           
        if(type == Type.CURRENTACCOUNT) return true;
        return false;
    }

    //metodos para validar saque dependendo da conta
    public boolean validWithDrawn(Type type, double balance, double withDraw) {
        Date dataAtual = new Date();       
        int hora = Integer.parseInt(new SimpleDateFormat("HH").format(dataAtual));        
            
        if (type == Type.EASYACCOUNT && (balance == 2000.00) && (withDraw > 0) && (withDraw <= balance) && (hora < 16 && hora > 8) && this.getStatus() == true) return true;
        if(type == Type.SAVINGACCOUNT && (balance >= withDraw) && (withDraw > 0) && (hora > 8 && hora <= 21 ) && this.getStatus() == true) return true;
        if(type == Type.CURRENTACCOUNT && (balance >= withDraw) && this.getStatus() == true) return true;

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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append("Email: " + this.getEmail());
        return super.toString() + stb.toString();
    }   

}