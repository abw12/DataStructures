package Java8;

import Java8.StreamAPI.EmplooyeeData;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class HighestSalary {

    public static void main(String[] args) {

        EmplooyeeData empObj = new EmplooyeeData();
        List<EmplooyeeData> data = empObj.getInitialList();


        //WAP to find highest salary of an employee from each dept
        //approach 1
        Comparator<EmplooyeeData> comapareBySalary=Comparator.comparing(EmplooyeeData::getSalary);
        Map<String, Optional<EmplooyeeData>> employeeMap=data.stream().collect(
                groupingBy(
                        EmplooyeeData::getDept,
                        Collectors.reducing(BinaryOperator.maxBy(comapareBySalary))
                )
        );
        System.out.println(employeeMap);

        //aproach 2
        Map<String,EmplooyeeData> employee2 = data.stream().collect(
                toMap(EmplooyeeData::getDept, Function.identity(), BinaryOperator.maxBy(Comparator.comparingDouble(EmplooyeeData::getSalary)))
        );

        //another simple example of the groupingBy collectors
        Map<Integer, List<EmplooyeeData>> groupByExp = data.stream()
                .collect(groupingBy(EmplooyeeData::getYearsOfExp, Collectors.toList()));
        System.out.println("Group By Exp: "+ groupByExp);

        // Compute sum of salaries by department
        Map<String, Double> salaryMapPerDept = data.stream()
                .collect(groupingBy(
                                EmplooyeeData::getDept,
                                Collectors.summingDouble(EmplooyeeData::getSalary)
                        )
                );

        //across all dept
        EmplooyeeData emplyeeWithMaxSalary = data.stream()
                .max(Comparator.comparingDouble(EmplooyeeData::getSalary))
                .orElseThrow(RuntimeException::new);
        System.out.println("Employee with Max Salary: " +emplyeeWithMaxSalary);


        //second highest salary across all dept
        EmplooyeeData emplooyeeData = data.stream()
                .sorted(Comparator.comparingDouble(EmplooyeeData::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElseThrow(RuntimeException::new);

        System.out.println("Second Highest Salary: "+ emplooyeeData);

        //dept wise most exp employee
        Map<String, EmplooyeeData> byExp=data.stream().collect(
                toMap(EmplooyeeData::getDept, Function.identity(), BinaryOperator.maxBy(Comparator.comparingInt(EmplooyeeData::getYearsOfExp)))
                );
        //onlygrouping by name
        Map<String,List<EmplooyeeData>> groupByName = data.stream().collect(groupingBy(EmplooyeeData::getName));

        //fetching all employee name which does not start with "M"
       List<String> employeeName=data.stream()
               .filter(employee -> !employee.getName().startsWith("M"))
               .map(EmplooyeeData::getName).collect(Collectors.toList());

       List<String>  empNames =  data.stream().filter(emp -> emp.getSalary() > 90000).map(emp -> emp.getName()).collect(Collectors.toList());

        System.out.println(employee2);
        System.out.println("byExp :: "+ byExp);
        System.out.println(employeeName);
        System.out.println("Employee with salary more than 90000: "+empNames);

        //sum of salary in dept dev
        Double sumOfSalaryInAllDept =data.stream().reduce(0.0,(partialValue,emp) -> partialValue + emp.getSalary() , Double::sum);
        System.out.println("Sum "+ sumOfSalaryInAllDept);

        //Q) Given a list of Employee objects, create a Map where the key is the employee's department and the value is the number of employees
        // in that department.

        Map<String,Long> deptWiseEmpCount = data.stream().collect(
                groupingBy(
                        EmplooyeeData::getDept,
                        Collectors.counting() //downstream collector method counting
                )
        );
        System.out.println("deptWiseEmpCount :: " + deptWiseEmpCount);
    }
}
