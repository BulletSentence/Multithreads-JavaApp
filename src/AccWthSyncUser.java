import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

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
        public synchronized void run() {
                userAccount.deposit(1);
            }
        }
    }

    private static class Account {
        // Thread will wait for priority
        private static Lock lock = new ReentrantLock(true);
        private int balance = 0;
        public int getBalanc() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                balance = newBalance;
        } finally {
                lock.unlock();
            }
    }

}
