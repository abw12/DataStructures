package HashCode_Equals;

public class MainDog {

    public static void main(String[] args) {
        Dog tommy = new Dog("Tommy");
        Labrador tommy2 = new Labrador("Tommy");

        System.out.println(tommy.equals(tommy2));
        System.out.println(tommy2.equals(tommy));  // if we override the equals method in subclass labrador then this turn false
                                                    // as we dont have the check for subclasses ref in the super class(dog) equals method

    }
}
