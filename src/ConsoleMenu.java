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
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.println("Account's holder name: " + account.getAccountHolderName());
                    System.out.println("Account Number: " + account.getAccountNumber());
                    System.out.println("Balance: " + account.getBalance());
                    break;

                case 3:
                    System.out.println("Enter your account number: ");
                    String depositAccountNumber = scanner.nextLine();

                    BankAccount depositAcc = bank.findAccount(depositAccountNumber);

                    if(depositAcc == null){
                        System.out.println("Account not found!");
                        break;
                    }
                    System.out.println("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();
                    depositAcc.deposit(depositAmount);
                    break;
                case 4:
                    System.out.println("Enter your account number: ");
                    String withdrawAccountNumber = scanner.nextLine();
                    
                    BankAccount withdrawAcc = bank.findAccount(withdrawAccountNumber);

                    if(withdrawAcc == null){
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.println("Enter the withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();
                    withdrawAcc.withdraw(withdrawAmount);  
                    break; 
                case 5:
                    System.out.println("Enter your account number: ");
                    String senderAccountNumber = scanner.nextLine();
                    BankAccount senderAcc = bank.findAccount(senderAccountNumber);

                    System.out.println("Enter the receiver account number: ");
                    String receiverAccountNumber = scanner.nextLine();
                    BankAccount receiverAcc = bank.findAccount(receiverAccountNumber);

                    if(senderAcc == null){
                        System.out.println("Sender Account not found!");
                        break;
                    }
                    else if(receiverAcc == null){
                        System.out.println("Receiver Account not found");
                        break;
                    }
                    
                    System.out.println("Enter the transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    scanner.nextLine();
                    bank.transfer(senderAccountNumber, receiverAccountNumber, transferAmount);
                    break;
                case 6:
                    ArrayList<BankAccount> accounts = new ArrayList<>();

                    if(accounts.isEmpty()){
                        System.out.println("The accounts are empty. Add account to view the details.");
                        break;
                    }

                    for(BankAccount acc : accounts){
                        System.out.println("-----------------------------------------------");
                        System.out.println("Account Number: " + acc.getAccountNumber());
                        System.out.println("Account holder's name: " + acc.getAccountHolderName());
                        System.out.println("Balance: " + acc.getBalance());
                        System.out.println("-----------------------------------------------");
                    }
                    break;
                default:
                    System.out.println("Invalid option! Please choose a valid option.");
                    break;
            }
        }
    }
}

