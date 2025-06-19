package BasicPrograms;

public class SwapNumbers {

//swap numbers without using the third variable
    public static void swapNumbers(int a, int b){
        b=b+a;
        a=b-a;
        b=b-a;
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main(String[] args) {
        int a =10;
        int b = 20;
        swapNumbers(a,b);
    }

}
