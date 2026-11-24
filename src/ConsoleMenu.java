import java.util.*;

public class ConsoleMenu {
    private Bank bank;
    private Scanner scanner;

    public ConsoleMenu(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("===== BANKING APPLICATION =====");
        System.out.println("1. Create an account");
        System.out.println("2. View account details");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Money");
        System.out.println("6. List all accounts");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private BankAccount selectAccount(){
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();

        BankAccount account = bank.findAccount(accountNumber);
        if (account == null) {
            System.out.println("Account not found!");
            return null;
        }

        return account;
    }

    private double readAmount(String message){
        System.out.print(message);
        double amount = scanner.nextDouble();
        scanner.nextLine();
        return amount;
    }

    private void createAccount() {
        System.out.print("Please Enter your name: ");
        String name = scanner.nextLine();
        BankAccount newAccount = bank.createAccount(name);
        System.out.println("Your account number is: " + newAccount.getAccountNumber());
    }

    private void viewAccountDetails() {
        BankAccount account = selectAccount();

        if(account == null){
            return;
        }

        System.out.println("Account's holder name: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }

    private void deposit() {
        BankAccount account = selectAccount();

        if(account == null){
            return;
        }

        Double amount = readAmount("Enter the deposit amount: ");
        account.deposit(amount);
    }

    private void withdraw() {
        BankAccount account = selectAccount();

        if(account == null){
            return;
        }
        Double amount = readAmount("Enther the withdrawal amount: ");
        account.withdraw(amount);
    }

    public void transfer() {
        System.out.print("Enter your account number: ");
        String senderAccountNumber = scanner.nextLine();
        BankAccount senderAcc = bank.findAccount(senderAccountNumber);

        System.out.print("Enter the receiver account number: ");
        String receiverAccountNumber = scanner.nextLine();
        BankAccount receiverAcc = bank.findAccount(receiverAccountNumber);

        if (senderAcc == null) {
            System.out.println("Sender Account not found!");
            return;
        } else if (receiverAcc == null) {
            System.out.println("Receiver Account not found");
            return;
        }

        Double amount = readAmount("Enther the transfer amount: ");
        bank.transfer(senderAccountNumber, receiverAccountNumber, amount);
    }

    public void listAllAccounts() {
        ArrayList<BankAccount> accounts = bank.listAccounts();

        if (accounts.isEmpty()) {
            System.out.println("The accounts are empty. Add account to view the details.");
            return;
        }

        for (BankAccount acc : accounts) {
            System.out.println("-----------------------------------------------");
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Account holder's name: " + acc.getAccountHolderName());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("-----------------------------------------------");
        }
    }

    public void start() {
        boolean running = true;

        while (running) {
            try {
                displayMenu();
                int option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 0:
                        running = false;
                        break;

                    case 1:
                        createAccount();
                        break;

                    case 2:
                        viewAccountDetails();
                        break;

                    case 3:
                        deposit();
                        break;

                    case 4:
                        withdraw();
                        break;

                    case 5:
                        transfer();
                        break;

                    case 6:
                        listAllAccounts();
                        break;

                    default:
                        System.out.println("Invalid option! Please choose a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}
