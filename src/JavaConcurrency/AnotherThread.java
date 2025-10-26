package JavaConcurrency;

import static JavaConcurrency.ThreadColor.ANSI_GREEN;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_GREEN + " Hello from "+currentThread().getName());

        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println(ANSI_GREEN+ "Someone Awake me before 5 seconds ");
            return ;
        }


        System.out.println(ANSI_GREEN+ "Five seconds have passed I'm awake");
    }

}
