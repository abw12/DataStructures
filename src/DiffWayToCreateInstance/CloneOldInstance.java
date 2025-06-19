package DiffWayToCreateInstance;

public class CloneOldInstance implements Cloneable
{

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        // Super() keyword refers to parent class
        return super.clone();
    }

    // Declaring and initializing string
    String name = "GeeksForGeeks";

    // Method 2
    // main driver method
    public static void main(String[] args)
    {
        //1st way to create an obj uisng new keyword
        CloneOldInstance obj1 = new CloneOldInstance();

        // Try block to check for exceptions
        try {

            // Using the clone() method
            CloneOldInstance obj2 = (CloneOldInstance)obj1.clone();

            // Print and display the main class object
            // as created above
            System.out.println(obj2.name);
        }

        // Catch block to handle the exceptions
        catch (CloneNotSupportedException e) {

            // Display the exception
            // using printStackTrace() method
            e.printStackTrace();
        }
    }


}
