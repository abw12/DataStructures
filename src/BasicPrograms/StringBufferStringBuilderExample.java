package BasicPrograms;

public class StringBufferStringBuilderExample {


    public static void concat1(String s1){
        s1=s1 + " Wasave";
    }

    public static void concat2(StringBuilder s2){
        s2.append("Wasave");
    }
    public static void concat3(StringBuffer s3){
        s3.append("Wasave");
    }

    public static void main(String[] args) {

        String s1="Abhishek";
        //it does not change  the s1 string in main method as String class is immutable
        concat1(s1);
        System.out.println("String: "+s1);

        StringBuilder s2 = new StringBuilder("Abhishek");
        //it change the string s2 in main class as the StringBuilder is mutable class
        concat2(s2);
        System.out.println("StringBuilder: "+s2);

        StringBuffer s3=new StringBuffer("Abhishek");
        //it changes the string s3 in main method as the StringBuffer is mutable class
        concat3(s3);
        System.out.println("StringBuffer: "+s3);


        //String pool concept
      //Object Initialization (Dynamic)
        String ss1 = new String("abhishek"); // this will create a constant in  string pooled area and  a String object will be created in the heap area
        ss1 = new String("wasave"); //again it will create a new object in heap area
        String ss3 = ss1; //now here this will not create a new string constant in stringpool area as it is already present in the string polled area  after above two statement
        String ss4 = "abhishek"; //same is here
        System.out.println(ss1.equals(ss3));
        System.out.println(ss1 == ss3);
        System.out.println(ss3 == ss4); //this == means we are checking equality of reference and not the value of the  string

    }
}
