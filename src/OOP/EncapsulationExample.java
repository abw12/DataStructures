package OOP;

class Student{
    //since we make these variables as private they can't be access outside the without using the getter and setter method
    //which is example of data-hiding(Encapsulation in java)
    private int rollNo;
    private String name;
    private  String address;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public void setRollNo(int rollNo){
        this.rollNo=rollNo;
    }

    public int getRollNo(){
        return this.rollNo;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
    }
}


public class EncapsulationExample {

    public static void main(String[] args) {
        Student s1= new Student();
        s1.setName("Abhishek");
        s1.setRollNo(10);
        s1.setAddress("virar");
//        s1.name="Sarang"; this is not allowed
        System.out.println(s1.getName());
        System.out.println(s1.getAddress());
        System.out.println(s1.getRollNo());

    }

}
