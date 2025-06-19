package Java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

//example of how to implement an functional interface
//it should have only one abstarct method , can have multiple default and static methods
@FunctionalInterface
public interface UPIPayment {
    //abtract method as we dont have any implementation
    String doPayment(String source,String dest,String amount);

    default double getScracthCard(){
        return new Random().nextDouble();
    }

    static String datePattern(String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date());
    }
}
