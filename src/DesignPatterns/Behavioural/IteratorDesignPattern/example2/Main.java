package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Abhishek","dev",50000));
        employeeList.add(new Employee("Vedant","test",23000));
        employeeList.add(new Employee("Sarang","dev",100000));
        Company here = new Company(employeeList);

        Iterator<Employee> iterator = here.createIterator();
        double totalSalary = 0;
        while(iterator.hasNext()){
            totalSalary+=iterator.next().getSalary();
        }
        System.out.println("Total Salary: " + totalSalary);
    }
}
