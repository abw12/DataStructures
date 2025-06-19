package DesignPatterns.Creational.PrototypeDesignPattern.Example1;


class Person implements Cloneable{

    private String name;
    private Address address;
    public Person(){}

    public Person(String name,Address address){
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone(); //copy the object as-is shallow copy
    }

    public Person deepClone(){
        return new Person(this.name,new Address(this.address.getCity()));    //Manually creating  a deep copy of the instance
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

class Address{
    private String city;

    public Address(){}
    public Address(String city){
        this.city=city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}

public class ShallowAndDeepCopyExample {

    public static void main(String[] args) {
        Person original = new Person("John", new Address("Mumbai"));


        Person shallow = null;
        try {
            // Shallow Copy
            shallow = (Person) original.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        // Deep Copy
        Person deep = original.deepClone();

        System.out.println("Before modification:");
        System.out.println("Original: " + original);
        System.out.println("Shallow:  " + shallow);
        System.out.println("Deep:     " + deep);

        // Modify the city via shallow copy
//        shallow.getAddress().setCity("Pune"); //will reflect changes on original object

        deep.getAddress().setCity("Pune"); //this change will not reflect on original object

        System.out.println("\nAfter modifying shallow copy's address:");
        System.out.println("Original: " + original); // will be affected!
        System.out.println("Shallow:  " + shallow);  // changed
        System.out.println("Deep:     " + deep);     // unchanged
    }
}
