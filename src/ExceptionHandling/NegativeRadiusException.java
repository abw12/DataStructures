package ExceptionHandling;

public class NegativeRadiusException extends Exception{

    public String toString(){
        return "Radius value cannot be negative";
    }
    public String getMessage(){
        return "Exception !! Radius value is Negative";
    }
}
