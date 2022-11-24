package entites;

public abstract class Account {
    private Integer accountNum;    
    private String name;
    private double balance;

    public Account(Integer accountNum, String name){
        this.setAccountNum(accountNum);
        this.setName(name);
    }

    //O metodo de deposito deve ser implementado em todo tipo de conta
    public abstract void deposit();

    //O metodo de saque deve ser implementado em todo tipo de conta
    public abstract double withDraw();

    public Integer getAccountNum() {
        return accountNum;
    }

    //Metodos acessores e modificadores
    private void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return this.balance;
    }    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        StringBuilder stb = new StringBuilder();
        stb.append("Name : " + this.getName() + "\n");
        stb.append("Account Number: " + this.getAccountNum() + "\n");
        stb.append("Balance: " + this.getBalance());
        return stb.toString();
    }

}