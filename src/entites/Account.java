package entites;

public abstract class Account {
    private Integer accountNum;    
    private String name;
    protected double balance;

    public Account(){

    }
    public Account(Integer accountNum, String name){
        this.setAccountNum(accountNum);
        this.setName(name);
    }

    //O metodo de deposito deve ser implementado em todo tipo de conta
    public abstract void deposit(double depositValue);

    //O metodo de saque deve ser implementado em todo tipo de conta
    public abstract double withDraw(double withDrawValue);

    public Integer getAccountNum() {
        return accountNum;
    }

    //Metodos acessores e modificadores
    private void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
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
        stb.append("Balance: " + this.getBalance() + "\n");
        return stb.toString();
    }

}