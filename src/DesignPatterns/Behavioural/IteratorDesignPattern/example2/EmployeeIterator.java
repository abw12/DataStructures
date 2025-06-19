package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//concrete Iterator
public class EmployeeIterator implements Iterator<Employee>{

    private List<Employee> employees = new ArrayList<>();
    private int currentIndex=0;
    public EmployeeIterator(List<Employee> employees){
        this.employees=employees;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < employees.size();
    }

    @Override
    public Employee next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return employees.get(currentIndex++);
    }
}
