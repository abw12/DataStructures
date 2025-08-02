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
        System.out.println("List of emails :: " + listOfEmails);

        // 1. collect every employee email address
        List<String> empEmailAddressWithMapMulti = empList.stream()
                .<String>mapMulti(
                        (emp, consumer) -> emp.getEmailAddresses()
                                .forEach(consumer)
                )
                .toList();
        System.out.println("empEmailAddressWithMapMulti :: " + empEmailAddressWithMapMulti);

    }
}
