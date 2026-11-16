public class Main {
    public static void main(String[] args) {
        Bank Zizou = new Bank("Donk");
        ConsoleMenu menu = new ConsoleMenu(Zizou);

        menu.start();
       
    }
}