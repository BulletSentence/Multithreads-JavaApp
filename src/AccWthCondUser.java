import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccWthCondUser {
    private static Account account = new Account();
    public static void main(String[] args) {
        System.out.println("Thread One \t\t Tread Two \t\t Balance");
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // This Withdraw task only run when it have money
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.shutdown();

        while (!executor.isShutdown()){

        }
    }

    public static class DepositTask implements Runnable {
        public void run(){
            while(true) {
                account.deposit((int)(Math.random() * 10) + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
        private static Lock lock = new ReentrantLock(true);
        private static Condition newDeposit = lock.newCondition();

        private int balance = 0;
        public int getBalance(){
            return balance;
        }

        public void withdraw(int amount){
            lock.lock();
            try {
                while (balance < amount) {
                    System.out.println("\t\t\tWait for Deposit");
                    newDeposit.await();
                }
                balance -= amount;
                System.out.println("\t\t\tWithdraw Completed (" + amount + ")R$");
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void deposit(int amount){

        }
    }

}
