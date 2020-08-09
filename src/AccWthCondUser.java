import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
