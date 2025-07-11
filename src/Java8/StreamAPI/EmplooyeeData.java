package Java8.StreamAPI;

public class EmplooyeeData {

    private String Name;
    private String dept;
    private double salary;

    private int yearsOfExp;

    public EmplooyeeData(String name, String dept, double salary, int yearsOfExp) {
        Name = name;
        this.dept = dept;
        this.salary = salary;
        this.yearsOfExp = yearsOfExp;
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
