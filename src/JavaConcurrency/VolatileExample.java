package JavaConcurrency;

public class VolatileExample {
    //this global variable is stored in the main memory (process memory - heap memory)
        private static volatile int num = 0; //if we remove the volatile keyword here the threads working get unsynchronized and it never stops

        public static void main(String[] args) {
                new  ChangeListener().start();
                new ChangeMaker().start();
        }

        static class ChangeListener extends Thread{
            @Override
            public void run(){
                int local_value =num; //this variable is stored in the thread stack memory (processor memory)
                while(local_value < 5){
                    if(local_value!=num){
                        System.out.println("Got Change for num " + num);
                        local_value=num;
                    }
                }

            }
        }

        static class ChangeMaker extends  Thread {
            @Override
            public void run(){
                int local_value=num; //this variable is stored in the thread stack memory (processor memory)
                while(num < 5) {
                    System.out.println("Increamenting num to " + ++local_value);
                    num = local_value;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

