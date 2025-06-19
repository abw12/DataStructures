package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

import java.util.ArrayList;
import java.util.List;

public class Company implements Aggregate<Employee>{

    private List<Employee> employees = new ArrayList<>();

    public Company(List<Employee> employees){
        this.employees=employees;
    }
    @Override
    public Iterator<Employee> createIterator() {
        return new EmployeeIterator(employees);
    }
}
