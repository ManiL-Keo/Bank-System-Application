import java.util.*;

public class ConsoleMenu {
    private Bank bank;
    private Scanner scanner;

    public ConsoleMenu(Bank bank){
    this.bank = bank; 
    this.scanner = new Scanner(System.in);
    }

    public void displayMenu(){
        System.out.println("===== BANKING APPLICATION =====");
        System.out.println("1. Create an account");
        System.out.println("2. View account details");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Money");
        System.out.println("6. List all accounts");
        System.out.println("0. Exit");
        System.out.println("Choose an option: ");
    }

    public void start(){
        boolean running = true;
        
        while(running){
            displayMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    running = false;
                    break;
                case 1:
                    System.out.println("Please Enter your name: ");
                    String name = scanner.nextLine();
                    BankAccount newAccount = bank.createAccount(name);
                    System.out.println("Your account number is: " + newAccount.getAccountNumber());
                    break;
                case 2:
                    System.out.println("Enter your account number: ");
                    String accountNumber = scanner.nextLine();

                    BankAccount account = bank.findAccount(accountNumber);

                    if(account == null){
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.println("Account's holder name: " + account.getAccountHolderName());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 3:
                    System.out.println("Enter your account number: ");
                    String dAccountNumber = scanner.nextLine();

                    BankAccount dAcc = bank.findAccount(dAccountNumber);

                    if(dAcc == null){
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.println("Enter the deposit amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    dAcc.deposit(amount);
                    break;
                case 4:
                    System.out.println("Enter your account number: ");
                    String wAccountNumber = scanner.nextLine();
                    
                    BankAccount wAcc = bank.findAccount(wAccountNumber);

                    if(wAcc == null){
                        System.out.println("Accout not found");
                        break;
                    }

                    System.out.println("Enter the withdraw amount: ");
                    double wAmount = scanner.nextDouble();
                    scanner.nextLine();
                    wAcc.withdraw(wAmount);  
                    break;                  
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
                    break;
            }
        }
    }
}

