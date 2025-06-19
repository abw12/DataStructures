package Java8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

class EmplooyeeData {

    private String Name;
    private String dept;
    private double salary;

    private int yearsOfExp;

    public EmplooyeeData(String name, String dept, double salary,int yearsOfExp) {
        Name = name;
        this.dept = dept;
        this.salary = salary;
        this.yearsOfExp=yearsOfExp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearsOfExp() {
        return yearsOfExp;
    }

    public void setYearsOfExp(int yearsOfExp) {
        this.yearsOfExp = yearsOfExp;
    }

    @Override
    public String toString() {
        return "EmplooyeeData{" +
                "Name='" + Name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", yearsOfExp=" + yearsOfExp +
                '}';
    }
}

public class HighestSalary {

    public static void main(String[] args) {

        List<EmplooyeeData> data = Stream.of(new EmplooyeeData("Abhishek","Dev",60000,3),
                new EmplooyeeData("Manali","Dev",80000,14),
                new EmplooyeeData("Jashma","QA",50000,4),
                new EmplooyeeData("Amit","QA",120000,3),
                new EmplooyeeData("Manoj","Dev",160000,14),
                new EmplooyeeData("Mahesh","Dev",260000,20),
                new EmplooyeeData("Vishal","DevOps",160000,15),
                new EmplooyeeData("Inder","DevOps",100000,18)
                ).collect(Collectors.toList());


        //WAP to find highest salary of an employee from each dept
        //approach 1
        Comparator<EmplooyeeData> comapareBySalary=Comparator.comparing(EmplooyeeData::getSalary);
        Map<String, Optional<EmplooyeeData>> employeeMap=data.stream().collect(
                Collectors.groupingBy(
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
                .collect(Collectors.groupingBy(EmplooyeeData::getYearsOfExp, Collectors.toList()));
        System.out.println("Group By Exp: "+ groupByExp);

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
        Map<String,List<EmplooyeeData>> groupByName = data.stream().collect(Collectors.groupingBy(EmplooyeeData::getName));

        //fetching all employee name which does not start with "M"
       List<String> employeeName=data.stream()
               .filter(employee -> !employee.getName().startsWith("M"))
               .map(employee -> employee.getName()).collect(Collectors.toList());

       List<String>  empNames =  data.stream().filter(emp -> emp.getSalary() > 90000).map(emp -> emp.getName()).collect(Collectors.toList());

        System.out.println(employee2);
        System.out.println("byExp :: "+ byExp);
        System.out.println(employeeName);
        System.out.println("Employee with salary more than 90000: "+empNames);

        //sum of salary in dept dev
        Double sumOfSalaryInAllDept =data.stream().reduce(0.0,(partialValue,emp) -> partialValue + emp.getSalary() , Double::sum);
        System.out.println("Sum "+ sumOfSalaryInAllDept);

        ///////////////////////////////////////////////////////////////////////////

        //Treemap output will sort the keys in alphabatical order maintaining the natural ordering of the keys(i.e name)
        // since we did not provide any comparator during Map creation time
//       The TreeMap, on the other hand, completely ignores the order in which entries come in.
//       It re-orders them using String.compareTo(key1, key2), because the key type is String and no comparator was supplied.
//       Hence the apparent “unsorted” output.
        TreeMap<String, Integer> treeMapByYrsOfExp = data.stream()
                .filter(e -> e.getYearsOfExp() > 10)
                .sorted(Comparator.comparingInt(EmplooyeeData::getYearsOfExp))
                .collect(toMap(EmplooyeeData::getName, EmplooyeeData::getYearsOfExp, (v1, v2) -> v2, TreeMap::new));

        //LinkedHashMap maintains and preserve the insertion order. so the sorted method result will be added into output map in sorted order itself
        //So the LinkedHashMap looks “sorted by years” only because you happen to insert in that order.
        //LinkedHashMap itself never sorts; it just remembers arrival order.
        LinkedHashMap<String, Integer> linkedHashMapByYrsOfExp = data.stream()
                .filter(e -> e.getYearsOfExp() > 10)
                .sorted(Comparator.comparingInt(EmplooyeeData::getYearsOfExp))
                .collect(toMap(EmplooyeeData::getName, EmplooyeeData::getYearsOfExp, (v1, v2) -> v2, LinkedHashMap::new));

        System.out.println("treeMapByYrsOfExp :: "+ treeMapByYrsOfExp);
        System.out.println("linkedHashMapByYrsOfExp :: "+ linkedHashMapByYrsOfExp);

        ///////////////////////////////////////////////////////////////////////////

        //using the custom comparator in treemap for custom object sorting or we cna also implement comparable interface in the EmployeeData class
        //to sort the custom object key using treemap, the thenComparing comes into picture when there is same yearofexp of two object/employee
        // in that case the comparator return 0 and then we again check with employee name and sort the data using name property.
        TreeMap<EmplooyeeData,String> empDataByDept = data.stream()
                .collect(toMap(
                        Function.identity(),
                        EmplooyeeData::getName,
                        (e1,e2) -> e2,
                        () -> new TreeMap<>(
                                Comparator.comparingInt(EmplooyeeData::getYearsOfExp).reversed()
                                        .thenComparing(EmplooyeeData::getName)
                        )
                ));

        System.out.println("empDataByDept :: " +empDataByDept);
    }
}
