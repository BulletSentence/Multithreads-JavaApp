public class AccWthSyncUser {

    public static void main(String[] args) {

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
