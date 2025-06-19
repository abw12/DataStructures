package DiffWayToCreateInstance;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Employee implements Serializable {
    private String name;
    private int no;

    public void setName(String name){
        this.name=name;
    }

    public Employee(){
        System.out.println("public no-args constructor called...");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
    //    public Employee (String name){
//        this.name=name;
//        System.out.println("public parameterized constructor called...");
//    }
//
//    private Employee(String name,int no){
//        this.name=name;
//        this.no=no;
//        System.out.println("private parameterized constructor called...");
//    }

}


public class UsingConstructorClassMethod {



    public static void main(String[] args) throws NoSuchMethodException {

        Constructor<Employee> constructor = Employee.class.getConstructor();
        try {
            Employee emp1 = constructor.newInstance();

        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
