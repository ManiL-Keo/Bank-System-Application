public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Zizou");
        BankAccount acc1 = bank.createAccount("Manil");
        BankAccount acc2 = bank.createAccount("Donk");

        acc1.deposit(1000);
        System.out.println(acc1.getBalance());

        bank.transfer(acc1.getAccountNumber(), acc2.getAccountNumber(), 300.0);
        System.out.println(acc1.getBalance());
        System.out.println(acc2.getBalance());
    }
}