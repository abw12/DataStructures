package BasicPrograms;

public class MethodOverloadingExample {

    // Java Program to Illustrate Error Thrown in
// Method Overloading When Method Signature is Same and
// ReturnType is Different

// Importing required classes

    // Class 1
// Helper class
    static class Addition {

        // Method 1
        // Adding two integer value
        public int add(int a, int b)
        {
            // Summing up
            int sum = a + b;

            // Returning the sum
            return sum;
        }

        // Method 2
        // Adding three integer value
        // this is overloading the methods as we gave different parameter list
        //so only changing the return type will not consider the method as overloaded
        public double add(int a, int b,int c)
        {
            double sum = a + b + c;
            return sum;
        }
    }

    // Class 2
// Main class

        // Main driver method
        public static void main(String[] args)
        {
            // Try block to check for exceptions
            try {

                // Creating an object of above class
                Addition ob = new Addition();

                // Calling method 1 to sum 2 numbers
                int sum1 = ob.add(1, 2);

                // Printing sum of two numbers
                System.out.println(
                        "sum of the two integer value :" + sum1);

                // Calling method 2 to sum 3 numbers
                Double sum2 = ob.add(1, 2,3);

                // Printing sum of three numbers
                System.out.println(
                        "sum of the three integer value :" + sum2);
            }

            // Catch block to handle exceptions
            catch (Exception e) {

                // Display the exceptions on console
                System.out.println(e);
            }
        }

}
