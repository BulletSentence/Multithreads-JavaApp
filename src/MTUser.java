import java.util.concurrent.*;

public class MTUser {
    public static void main(String[] args) {
        Runnable printfirst = new PrintChar('a', 200);
        Runnable printSecond = new PrintNum(2,50);
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

    public PrintNum(int num1, int times1){
        num = num1;
        times = times1;
    }
}

class PrintChar implements Runnable {
    private char letter;
    private int times;

    @Override
    public void run(){
        for (int i = 0; i < times; i++){
            System.out.println(letter);
        }
    }

    public PrintChar(char letter1, int times1){
        letter = letter1;
        times = times1;
    }
}