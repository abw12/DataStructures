package Java8;

import java.util.List;

public class LambdaExpExample {
    private int x;
    //this is called constructor chaining to call one constructor from another constructor
    //To chain to a particular superclass constructor instead of one in the same class, use super instead of this.
    // Note that you can only chain to one constructor, and it has to be the first statement in your constructor body.
    public LambdaExpExample(){
//        System.out.println("i'm in 1st constructor"); // will give that call to this() must be a first statement in the contructor
        this(3);
    }

    public LambdaExpExample(int x) {
        this.x = x;
        System.out.println(this.x);
    }


    public static void main(String[] args) {
//        new Thread(() ->{
//                System.out.println("Printing from main runabble");
//        }).start();

        LambdaExpExample obj =new LambdaExpExample();

//        List<Employee> listOfEmployee = Stream.of(new Employee("abhishek",845931961,"Virar"),
//                new Employee("vedant",878965862,"Andheri"),
//                new Employee("sarang",888967862,"NSP")).collect(Collectors.toList());

//        listOfEmployee.forEach((employee) -> System.out.println("Names: " + employee.getName()));

    }
}

//no need to write this below extra class just to make use of it in the main class instead using lambda expression we can easily achieve it
//class testCode implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("Print from Runnable testcode");
//    }
//}

class Employee extends LambdaExpExample{

    public String name;
    public double phnNo;
    public String address;

    public List<String> emails;

    protected Employee(String name, double phnNo, String address,List<String> emails) {
        super(5); //use super() to call the inherited class constructor
        this.name = name;
        this.phnNo = phnNo;
        this.address = address;
        this.emails=emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPhnNo() {
        return phnNo;
    }

    public void setPhnNo(double phnNo) {
        this.phnNo = phnNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}
