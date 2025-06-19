package BasicPrograms;

public class Factorial {

    public static void factorial(int num){
        int factorial=num;

        for(int i=num-1; i > 0 ; i--){
            factorial=factorial*i;
        }
        System.out.println(factorial);
    }

    public static void main(String[] args) {
        int num=5 ;

        factorial(9);
    }
}
