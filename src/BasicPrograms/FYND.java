package BasicPrograms;

class Employee {

    static {
        System.out.println("Running some static content at class initialization");
    }

    String name;
    String address;

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    public boolean equals(Object o){
        if(o == null) return false;
        if( o == this) return true;
        return this.name == ((Employee) o).getName();
    }
}

public class FYND{

    public static void main(String[] args) {

        Employee obj1 =new Employee("abhishek","Virar");
        Employee obj2 = new Employee("abhishek","Virar");
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1 == obj2); //compares that two references  are identical or not
    }

}


