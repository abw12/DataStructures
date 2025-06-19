package JavaConcurrency;

import static JavaConcurrency.ThreadColor.ANSI_PURPLE;

public class MyRunnable implements  Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from MyRunnable run() method");

    }
}
