import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccWthoutSyncUser {
    private static Account userAccount = new Account();

    public static void main(String[] args) {

        // Quantity of Cache for Threads
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++){
            // Add account money +1
            executor.execute(new AddPenny());
        }
        // Turn off threads
        executor.shutdown();

        while (!executor.isShutdown()){

        }
        System.out.println("What is balance? " + userAccount.getBalance());
    }

    private static class AddPenny implements Runnable {
        public void run(){
            userAccount.deposit(1);
        }
    }

    private static class Account {
        private int balance = 0;

        public void deposit(int amount) {
            int newBalance = balance + amount;
            
            balance = newBalance;
        }

        public int getBalance() {
            return balance;
        }
    }
}
