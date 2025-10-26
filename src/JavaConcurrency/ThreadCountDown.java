package JavaConcurrency;


//example to demonstrate that thread execution is does not guarantee the order of threads which can be completed or terminated , sequence is undetermined
public class ThreadCountDown {
    public static void main(String[] args) {

//        CountDown countDown1 =new CountDown();
//        CountDown countDown2 =new CountDown();
        CountDown countDown =new CountDown();

        CountDownThread th1 = new CountDownThread(countDown);
        CountDownThread th2 = new CountDownThread(countDown);
        th1.setName("Thread 1");
        th2.setName("Thread 2");
        th1.start();
        th2.start();

    }
}

class CountDown{
    //if we introduced an instance variable like below it create a problem and you'll observe few numbers are being skipped by each thread
    //this happens bcoz as we know each thread has his own thread stack but each thread share the same heap memory of the process
    //so the instance variable get stored in heap memory of the process they both share the same value of i if we are passing the same countdown
    // instance to both the countdownthread instances above and so i keep decrementing it on execution of the respective thread
    //so when an threads get suspended after execution it has already decremented the value of i in the heap memory and therefore the other thread get the
    //different value then what it has when it got suspended before
    //this situation is race condition or interfering thread
    //to overcome this we can create two separate obj/instances of the countdown class and pass different instance to the countdown thread class
    //although this approach is not recommended in real world app as creating separate obj may result in unexpected behaviour based on business logic
    //better approach here is to use synchronized method or synchronized block of code as it only allow one thread to access the object at one time
    //
    private int i; //instance variable
    public void doCountDown(){
        String color;
        switch(Thread.currentThread().getName()){
            case "Thread 1":
                color=ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color=ThreadColor.ANSI_RED;
                break;
            default:
                color=ThreadColor.ANSI_GREEN;
                break;
        }
        //since we only need the value of i to be synchronized we use synchronized block instead of declaring the method with synchronized keyword
        //'this' refers to countdown obj
        synchronized (this){
            for(i=10;i > 0;i--){
                System.out.println(color + Thread.currentThread().getName() + " : i="+i);
            }
        }

    }
}

class CountDownThread extends Thread{
    private CountDown countDown;

    public  CountDownThread(CountDown countDown){
        this.countDown=countDown;
    }
    @Override
    public void run() {
        countDown.doCountDown();
    }
}
