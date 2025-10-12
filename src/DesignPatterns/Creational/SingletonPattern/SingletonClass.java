package DesignPatterns.Creational.SingletonPattern;

public class SingletonClass {

//    1st way to create an singleton class
// Declaration and definition of variable occur
// simultaneously
//  Eager initialisation
    private String name;
    private int id;

    //singleton class with parameters is no longer remain singleton
    // instantiation will always be parameter-less. Otherwise your singleton is not a singleton.
    private static SingletonClass singletonClass = new SingletonClass();
        
    private SingletonClass(){
    }

    public static SingletonClass getInstance(){
        return singletonClass;
    }

    public void print(){
        System.out.println(singletonClass);
    }

    //this is how you pass arguments to an singleton object
    public void init(String name,int id){
         this.name=name;
         this.id=id;
//         System.out.println("Name: " +singletonClass.name + " ID: "+singletonClass.id);
    }

    @Override
    public String toString() {
        return "SingletonClass{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
//2nd way to create a singleton class
//    lazy  initialization
class SingletonLazy{

    private static  SingletonLazy singletonLazy ;

    // check inside the constructor if an instance already exist or not since if using reflection api someone try to create
    // instance of the private class than it should be blocked
//    reflection can break Singleton by bypassing access controls on constructors,
//    but defensive coding in the constructor or using an enum-based Singleton can prevent this vulnerability
    private SingletonLazy(){
        if (singletonLazy != null){
            throw new RuntimeException("Reflection cannot be used here!");
        }
    }

    public static SingletonLazy getSingletonLazy(){
        // Condition check
        // When instance is null
        // a new object of Singleton class is created
        if(singletonLazy == null){
            singletonLazy= new SingletonLazy();
        }
        return singletonLazy;
    }
}

//3rd way to create singleton class
// for multi-threading purpose although not recommended way
class SingletonSynchronizedMethod{

    private static  SingletonSynchronizedMethod singletonSynchronizedMethod;

    private SingletonSynchronizedMethod(){}

    // Condition check
    // When instance is null
    // a new object of Singleton class is created
    public static synchronized SingletonSynchronizedMethod getSingletonSynchronizedMethod(){
        if( singletonSynchronizedMethod == null){
            singletonSynchronizedMethod = new SingletonSynchronizedMethod();
        }
        return singletonSynchronizedMethod;
    }
}

//4th way to do it
//this is the way recommended for multi-threading as here we just locking the block/segment of code instead of entire method
class SingletonDoubleLevelCheck{

    private static SingletonDoubleLevelCheck singletonDoubleLevelCheck;

    private SingletonDoubleLevelCheck(){}

    public static SingletonDoubleLevelCheck getSingletonDoubleLevelCheck(){

        //first check
        if( singletonDoubleLevelCheck == null){

            synchronized (SingletonDoubleLevelCheck.class){
                if( singletonDoubleLevelCheck == null){
                    singletonDoubleLevelCheck = new SingletonDoubleLevelCheck();
                }
            }
        }
        return  singletonDoubleLevelCheck;
    }
}



