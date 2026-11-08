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

}