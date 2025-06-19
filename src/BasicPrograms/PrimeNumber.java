package BasicPrograms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import  java.util.Arrays;

public class PrimeNumber {

    public static void usingJava8(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 20);

        List<Integer> prime = numbers.stream().filter(PrimeNumber::isPrime).collect(Collectors.toList());
        System.out.println("UsingJava8: "+prime);
    }

    public static boolean isPrime(int num){
        return IntStream.rangeClosed(2,num/2).noneMatch(i -> num%i == 0);
    }

    public static boolean checkNumberIsPrime(int num){
        if(num == 0 || num == 1) return false;
        if(num == 2 ) return true;

        for(int i=2 ; i < num/2 ;i++){
            if( num%i ==0){
                return false;
            }
        }
        return true;
    }

    public static void EratosthenesAlgo(int range){


        boolean[] primes = new boolean[range+1]; //since 100 is inclusive ie 0 - 100
        Arrays.fill(primes,true);

        for(int i=2 ; i * i < range ; i++){
            if(primes[i]){
                for(int j=i * i ; j < range ; j+=i ){
                    primes[j]=false;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for(int i=2 ; i < primes.length ; i++){
            if(primes[i]){
                primeNumbers.add(i);
            }
        }
        System.out.println("Eratosthenes Algo: "+primeNumbers);


    }

    public static void main(String[] args) {
        //find prime numbers in 1 - 100
        List<Integer> primeNumbers = new ArrayList<>();

        boolean isPrime;
        int half,x,count=0;

        for(int i=2; i < 100 ;i ++){
            isPrime=true;
            half = i/2;
            for(x=half ; x>=2 ; x--){
                if(i%x == 0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(i);
                count++;
            }
        }

        System.out.println(primeNumbers);
        System.out.println("Total prime numbers in 1-100 is :  "+count);
        //using java 8 stream api
        usingJava8();

        //to check if given number is prime
        int num = 10;
        System.out.println("Num is Prime ?: "+checkNumberIsPrime(num));
        //another way to find prime is using Sieve of Eratosthenes algorithm
        //range of numbers
        int range =100;
        EratosthenesAlgo(range);

    }
}
