package DiffWayToCreateInstance;

// Java program to Illustrate Creation of Object
// Using new Instance

// Main class
//If we know the name of the class & if it has a public default constructor we can create an object Class.forName.
// We can use it to create the Object of a Class. Class.forName actually loads the Class in Java but doesn’t create any Object.
// To create an Object of the Class you have to use the new Instance Method of the Class.
class UsingClassForName {

    // Declaring and initializing string
    String name = "GeeksForGeeks";

    // Main driver method
    public static void main(String[] args) {
        // Try block to check for exceptions
        try {
            //deprecated since java 9
//          2nd way of creating an obj  by using newInstance() method of java.lang.Class class
            UsingClassForName cls = (UsingClassForName) Class.forName("UsingClassForName").newInstance();

            // Creating object of main class
            // using instance method
            UsingClassForName obj = UsingClassForName.class.newInstance();

            // Print and display
            System.out.println(obj.name);

            //more modern way to use the reflection api to create an instance of the class

        }

        // Catch block to handle the exceptions

        // Catch block 1
        // Handling ClassNotFound Exception
        catch (ClassNotFoundException e) {

            // Display the exception along with line number
            // using printStacktrace() method
            e.printStackTrace();
        }

        // Catch block 2
        // Handling InstantiationException
        catch (InstantiationException e) {

            e.printStackTrace();
        }

        // Catch block 2
        // Handling IllegalAccessException
        catch (IllegalAccessException e) {

            e.printStackTrace();
        }
    }
}

