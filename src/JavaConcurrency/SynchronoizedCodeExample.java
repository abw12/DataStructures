package JavaConcurrency;

import java.util.Random;

public class SynchronoizedCodeExample {
    public static void main(String[] args) {

        Message message =new Message();
        new Thread(new Writer(message)).start();
        new Thread(new Reader(message)).start();
    }
}

class Message {
    private String message;
    private boolean empty=true;

    public synchronized String read(){
        while(empty){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        empty=true;
        notifyAll(); //since we have only two thread here we can use notifyAll()
        return message;
    }

    public synchronized void write(String message){
        while (!empty){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        empty=false;
        this.message=message;
        notifyAll();
    }
}

//producer class
class Writer implements Runnable{

    private Message message;

    public Writer(Message message){
        this.message=message;
    }


    @Override
    public void run() {
        String input[]={
                "Hello I'm Abhishek",
                "I'm an upcoming java developer",
                "my dream company is Amazon",
                "and i will get there anyhow"
        };
        Random random=new Random();

        for(int i=0 ;i < input.length;i++){
            message.write(input[i]);
            try{
                Thread.sleep(random.nextInt(2000));
            }catch (InterruptedException e){

            }
        }
        message.write("Finished");
    }
}

//consumer class
class Reader implements Runnable{
    private  Message message;

    public Reader(Message message){
        this.message=message;
    }
    @Override
    public void run(){
        Random random =new Random();
        for(String latestMessage=message.read(); !latestMessage.equals("Finished");latestMessage=message.read()){
            System.out.println(latestMessage);
        }
        try{
            Thread.sleep(random.nextInt(2000));
        }catch (InterruptedException e){

        }
    }
}
