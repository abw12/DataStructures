package ExceptionHandling;

public class AreaOfCircle {
    //example of how we can throw and custom exception
    public static  double area(int r) throws NegativeRadiusException {
        if(r<0){
            throw new NegativeRadiusException();
        }
        double radius = Math.PI * r * r;
        return radius;
    }

    public static void main(String[] args) {

        int r=-2;
         //since area method throws an NegativeRadiusException
        // if we dont handle it here using try-catch block then it will give us an unhandledexception
        try{
            System.out.println(area(r));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
