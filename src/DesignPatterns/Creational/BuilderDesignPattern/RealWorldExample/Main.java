package DesignPatterns.Creational.BuilderDesignPattern.RealWorldExample;

//Builder pattern aims to “Separate the construction of a complex object from its representation
// so that the same construction process can create multiple different representations.”
//the builder pattern helps us in creating immutable classes with a large set of state attributes.
public class Main {
    public static void main(String[] args) {
        //User obj is the example of immutable class
        User user1 =new User.UserBuilder("Abhishek","Wasave")
                .withAge(24)
                .withEmail("wasaveabhishek@gmail.com")
                .withPhnNumber(78896452)
                .build();

        User user2 =new User.UserBuilder("Sarang","Thakre")
                .withAge(24)
                .withEmail("sarangThakre@gmail.com")
                .build();

        User user3 = new User.UserBuilder("Vedant","Jangam").withAge(24).build();

//        Please note that the above-created User object does not have any setter method,
//        so its state can not be changed once it has been built. This provides the desired immutability.
        System.out.println(user1.toString());
        System.out.println(user2.toString());
        System.out.println(user3.toString());
    }
}
