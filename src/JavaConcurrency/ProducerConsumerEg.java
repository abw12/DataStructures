package JavaConcurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static JavaConcurrency.ProducerConsumerEg.EOF;

public class ProducerConsumerEg {
    public static final String EOF="EOF";

    public static void main(String[] args) {
        List<String> buffer =new ArrayList<String>();
        //there is another way to make sure thread are synchronized other than using synchronized block of code is to use the reentrantlocks
        //we have to manually lock and ensure to unlock the code in ReentrantLock, which rather being done by synchronized keyword automatically
        //we can make use of try-finally block to make use of lock & unlock method so that we have to maintain the unlock at only one place
        //also try-finally block make sure that if there is any interference of thread or exception occurred then it release the lock no matter what
        ReentrantLock bufferLock =new ReentrantLock();
        MyProducer producer =new MyProducer(buffer,ThreadColor.ANSI_RED,bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer,ThreadColor.ANSI_CYAN,bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer,ThreadColor.ANSI_BLUE,bufferLock);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();

    }
}

class MyProducer implements Runnable{

    private List<String> buffer;
    private String color;

    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    @Override
    public void run() {
        Random random =new Random();
        String[] input={"1","2","3","4","5"};

        for(String i : input){
            try{
                System.out.println(color+"Adding..." + i);
                //we required to add synchronized block on buffer since it is an arraylist which by nature is not a thread safe (means un-synchronized)
                //therefore the multiple thread can perform actions on it at the same time resulting in unexpected behaviour
                //hence we have to synchronized the add and removing operation on arraylist to ensure that only one thread can perform CRUD operation on arraylist at a time
//                synchronized (buffer){
                bufferLock.lock();
                try{
                    buffer.add(i);
                }finally {
                    bufferLock.unlock();
                }
//                }

                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){
                System.out.println("Producer was Interrupted");
            }
        }

        System.out.println(color + "Adding EOF and Exiting");
//        synchronized (buffer){
           bufferLock.lock();
           try{
               buffer.add("EOF");
           }finally {
               bufferLock.unlock();
           }
//        }

    }
}

class MyConsumer implements  Runnable{
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color,ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }
    @Override
    public void run(){
        while(true){
            bufferLock.lock();
//           synchronized (buffer){
            //there is also tryLock  method which first check if the lock is acquired by thread or not though it is not useful in this example
            try{
                if(buffer.isEmpty()){
                    continue;
                }
                if(buffer.get(0).equals(EOF)){
                    System.out.println(color + "Exiting");
                    break;
                }else{
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }finally {
                bufferLock.unlock();
            }

//           }
        }
    }
}