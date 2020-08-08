public class AccWthCondUser {
    private static Account account = new Account();
    public static void main(String[] args) {

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
