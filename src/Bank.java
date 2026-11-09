import java.util.ArrayList;

public class Bank {
    String bankName;
    ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    int nextAccountNumber;

    public BankAccount createAccount(String accountHolderName){
        String accountNumber = String.valueOf(nextAccountNumber);
        BankAccount account = new BankAccount(accountNumber, accountHolderName);
        accounts.add(account);
        nextAccountNumber++;

        return account;
    }

    public BankAccount findAccount(String accountNumber){
        for(BankAccount account : accounts){
            if(account.getAccountNumber() == accountNumber){
                return account;
            }
        }

        return null;
    }

    public boolean transfer(String senderAccountNumber, String receiverAccountNumber, double amount){
        BankAccount sender = findAccount(senderAccountNumber);
        BankAccount receiver = findAccount(receiverAccountNumber);
        if((sender == null || receiver == null)){
            System.out.println("Please enter the account number of the account you want to transfer to!");
            return false;
        }
        else if (sender == receiver) {
            System.out.println("Cannot transfer to the same account!");
            return false;
        }
        else if(amount > 0 && amount <=sender.getBalance()){
            sender.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("Transfer has been proceed successfully!");
            return true;
        }
        else{
            System.out.println("Unsuccesfully Transfered! Please try again!");
            return false;
        }

    }

    public  ArrayList<BankAccount> listAccount(){
        return new ArrayList<>(accounts);
    }
};