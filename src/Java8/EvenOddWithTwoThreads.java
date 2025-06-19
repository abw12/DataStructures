package Java8;

//java 7 aprroach to run this program
public class EvenOddWithTwoThreads implements  Runnable{

    Object object;
    static int i=1;

    public EvenOddWithTwoThreads(Object obj){
        this.object=obj;
    }

    @Override
    public void run() {
        while(i<10){
            if(i%2==0 && Thread.currentThread().getName().equals("even")){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + " : "+i);
                    i++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(i%2!=0 && Thread.currentThread().getName().equals("odd")){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+ " : "+ i);
                    i++;
                    object.notify();
                }
            }
        }

    }

    public static void main(String[] args) {
        Object obj = new Object();
        Runnable th1 = new EvenOddWithTwoThreads(obj);
        Runnable th2= new EvenOddWithTwoThreads(obj);
        new Thread(th1,"even").start();
        new Thread(th2,"odd").start();

    }
}
