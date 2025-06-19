package JavaConcurrency;

import static JavaConcurrency.ThreadColor.*;

public class BasicThread {

    public static void main(String[] args) {
        System.out.println(ANSI_RED +"Hello from Main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        anotherThread.start();

//        System.out.println(ANSI_RED+ "Hello again from Main Thread !!");

        //since run method belongs to Runnable interface(which functional interface) which has overridden by Thread class
        // therefore we can write the below code using lambda expression
//        new Thread(){
//            @Override
//            public void run() {
//                System.out.println("Hello from Anonymous class thread");
//            }
//        }.start();
        new Thread(()-> System.out.println(ANSI_BLUE +"Hello from Anonymous class Thread")).start();

//        Thread myRunnable=new Thread(new MyRunnable());
//        myRunnable.start();

        //to call the above instance with anonymous class and override the run() method in the MyRunnable class
        new Thread(new MyRunnable(){
            @Override
            public void run() {
                  System.out.println(ANSI_PURPLE+ "Hello from anonymous MyRunnable class run() method");
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_PURPLE+ "Another Thread terminated or timed out , anonymous MyRunnable thread started execution again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_PURPLE+ "i couldn't wait after all i was interrupted");
                }
            }
        }).start();

        anotherThread.interrupt();
        System.out.println(ANSI_RED+ "Hello again from Main Thread !!");


    }
}
