import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccWthCondUser {
    private static Account account = new Account();
    public static void main(String[] args) {
        System.out.println("Thread One \t\t Tread Two \t\t Balance");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        while (!executor.isShutdown()){

        }
    }

    public static class DepositTask implements Runnable {
        public void run(){
            while(true) {

            }
        }
    }

    public static class WithdrawTask implements Runnable {
        public void run() {
            while (true) {
                account.withdraw((int)(Math.random() * 10) + 1);
            }
        }
    }

    private static class Account {
        private int balance = 0;
        public int getBalance(){
            return balance;
        }

        public void withdraw(int amount){

        }

        public void deposit(int amount){

        }
    }

}
