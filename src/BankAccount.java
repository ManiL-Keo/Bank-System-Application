public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance = 0.0;

    public BankAccount(String accountNumber, String accountHolderName){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName){
        this.accountHolderName = accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public  double deposit(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return this.balance;
        }
        balance += amount;
        return balance;
    }
    
    public double withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount");
            return this.balance;
        }
        else if(amount > balance){
            System.out.println("Insufficient balance");
            return this.balance;
        }
        balance -= amount;
        return balance;
    }

}