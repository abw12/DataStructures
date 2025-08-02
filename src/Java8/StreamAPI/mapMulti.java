package Java8.StreamAPI;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class mapMulti {

    public static void main(String[] args) {
        EmplooyeeData empObj = new EmplooyeeData();
        List<EmplooyeeData> empList = empObj.getInitialList();

        // map one-to-one transfromation
        Set<String> distinctDept =  empList.stream().map(EmplooyeeData::getDept).collect(Collectors.toSet());

        //flatmap one-to-many mapping
        //using the flatmap we can extract all the emailId across employees
        List<String> listOfEmails = empList.stream().flatMap(emp -> emp.getEmailAddresses().stream()).toList();
        System.out.printf("List of emails :: " + listOfEmails);


    }
}
