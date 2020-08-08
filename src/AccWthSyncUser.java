import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccWthSyncUser {
    private static Account userAccount = new Account();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i = 0; i < 100; i++) {
            executor.execute(new AddPenny());
        }
        executor.shutdown();
        while (!executor.isShutdown()){

        }
        System.out.println("What is balance? " + userAccount.getBalanc());
    }

    private static class AddPenny implements Runnable {
        public void run() {
            synchronized (userAccount){
                userAccount.deposit(1);
            }
        }
    }

    private static class Account {
        private int balance = 0;
        public int getBalanc() {
            return balance;
        }

        public void deposit(int amount) {

        }
    }

}
