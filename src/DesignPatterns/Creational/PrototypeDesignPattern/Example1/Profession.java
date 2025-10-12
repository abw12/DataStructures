package DesignPatterns.Creational.PrototypeDesignPattern.Example1;

public abstract class Profession implements Cloneable{

    public int id;
    public String name;

    abstract void print();

    public Object cloneMethod(){
        Object clone =null;

        try{
            clone=super.clone(); //shallow copy since in java Object.clone method return a shallow copy
        }catch(CloneNotSupportedException e){
            //error will be thrown if the object which is trying to be cloned does not implement cloneable interface
            e.printStackTrace();
        }
        return  clone;
    }
}
