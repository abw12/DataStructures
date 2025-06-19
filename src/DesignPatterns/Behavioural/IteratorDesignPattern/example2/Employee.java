package DesignPatterns.Behavioural.IteratorDesignPattern.example2;

public class Employee {

    private String empName;
    private String empDesignation;
    private double salary;

    public Employee(){}
    public Employee(String empName, String empDesignation, double salary) {
        this.empName = empName;
        this.empDesignation = empDesignation;
        this.salary = salary;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
