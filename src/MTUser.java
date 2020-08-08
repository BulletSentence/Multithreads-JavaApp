public class MTUser {
    public static void main(String[] args) {

    }
}

class PrintNum extends Thread {
    private int num;
    private int times;

    @Override
    public void run(){
        for(int i = 0; i < times; i++ ){
            System.out.println(num);
        }
    }

    

}
