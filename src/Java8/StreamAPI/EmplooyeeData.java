package Java8.StreamAPI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EmplooyeeData {

    private String name;
    private String dept;
    private double salary;
    private int yearsOfExp;
    private List<String> emailAddresses;
    private List<String> phoneNumbers;
    private LocalDate joiningDate;
    private List<String> skills;
    private String location;
    private boolean isRemote;
    private List<Project> projects;
    private int age;

    public EmplooyeeData() {
        this.emailAddresses = new ArrayList<>();
        this.phoneNumbers = new ArrayList<>();
        this.skills = new ArrayList<>();
        this.projects = new ArrayList<>();
    }

    public EmplooyeeData(String name, String dept, double salary, int yearsOfExp) {
        this();
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.yearsOfExp = yearsOfExp;
    }

    public EmplooyeeData(String name, String dept, double salary, int yearsOfExp,
                         List<String> emailAddresses, List<String> phoneNumbers,
                         LocalDate joiningDate, List<String> skills, String location,
                         boolean isRemote, List<Project> projects, int age) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.yearsOfExp = yearsOfExp;
        this.emailAddresses = emailAddresses;
        this.phoneNumbers = phoneNumbers;
        this.joiningDate = joiningDate;
        this.skills = skills;
        this.location = location;
        this.isRemote = isRemote;
        this.projects = projects;
        this.age = age;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmplooyeeData{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", yearsOfExp=" + yearsOfExp +
                ", emailAddresses=" + emailAddresses +
                ", phoneNumbers=" + phoneNumbers +
                ", joiningDate=" + joiningDate +
                ", skills=" + skills +
                ", location='" + location + '\'' +
                ", isRemote=" + isRemote +
                ", projects=" + projects +
                ", age=" + age +
                '}';
    }

    public List<EmplooyeeData> getInitialList() {
        Project p1 = new Project("Customer Portal", "HIGH", 12);
        Project p2 = new Project("Payment Gateway", "CRITICAL", 8);
        Project p3 = new Project("Data Migration", "MEDIUM", 6);
        Project p4 = new Project("Mobile App", "HIGH", 10);
        Project p5 = new Project("Cloud Migration", "CRITICAL", 18);
        Project p6 = new Project("AI Chatbot", "MEDIUM", 9);

        return Stream.of(
                new EmplooyeeData("Abhishek", "Dev", 60000, 3,
                        Arrays.asList("abhishek@company.com", "abhi.personal@gmail.com"),
                        Arrays.asList("555-123-4567", "555-987-6543"),
                        LocalDate.of(2020, 5, 10),
                        Arrays.asList("Java", "Spring", "MySQL"),
                        "Bangalore", false,
                        Arrays.asList(p1, p3), 28),

                new EmplooyeeData("Manali", "Dev", 80000, 14,
                        Arrays.asList("manali@company.com"),
                        Arrays.asList("555-345-6789"),
                        LocalDate.of(2009, 3, 15),
                        Arrays.asList("Java", "Microservices", "AWS", "MongoDB"),
                        "Mumbai", true,
                        Arrays.asList(p2, p5), 38),

                new EmplooyeeData("Jashma", "QA", 50000, 4,
                        Arrays.asList("jashma@company.com", "jashma.qa@gmail.com"),
                        Arrays.asList("555-567-8901"),
                        LocalDate.of(2019, 7, 25),
                        Arrays.asList("Selenium", "Cucumber", "JUnit"),
                        "Pune", false,
                        Arrays.asList(p1, p4), 29),

                new EmplooyeeData("Amit", "QA", 120000, 3,
                        Arrays.asList("amit@company.com"),
                        Arrays.asList("555-678-9012", "555-222-3333"),
                        LocalDate.of(2021, 1, 5),
                        Arrays.asList("Selenium", "Appium", "Postman"),
                        "Delhi", false,
                        Arrays.asList(p2), 27),

                new EmplooyeeData("Manoj", "Dev", 160000, 14,
                        Arrays.asList("manoj@company.com", "manoj.dev@outlook.com"),
                        Arrays.asList("555-789-0123"),
                        LocalDate.of(2008, 11, 10),
                        Arrays.asList("Java", "Spring", "Kafka", "Docker", "Kubernetes"),
                        "Bangalore", true,
                        Arrays.asList(p2, p5, p6), 40),

                new EmplooyeeData("Mahesh", "Dev", 260000, 20,
                        Arrays.asList("mahesh@company.com"),
                        Arrays.asList("555-890-1234", "555-432-1098"),
                        LocalDate.of(2003, 4, 20),
                        Arrays.asList("Java", "Architecture", "Cloud", "AWS", "Azure"),
                        "Hyderabad", true,
                        Arrays.asList(p5, p6), 45),

                new EmplooyeeData("Vishal", "DevOps", 160000, 15,
                        Arrays.asList("vishal@company.com", "vishal.devops@gmail.com"),
                        Arrays.asList("555-901-2345"),
                        LocalDate.of(2008, 6, 15),
                        Arrays.asList("Jenkins", "Docker", "Kubernetes", "AWS", "Terraform"),
                        "Pune", false,
                        Arrays.asList(p3, p5), 39),

                new EmplooyeeData("Inder", "DevOps", 100000, 18,
                        Arrays.asList("inder@company.com"),
                        Arrays.asList("555-012-3456", "555-789-4561"),
                        LocalDate.of(2005, 9, 5),
                        Arrays.asList("AWS", "GCP", "Docker", "Kubernetes", "Python"),
                        "Mumbai", true,
                        Arrays.asList(p3, p4, p5), 42)
        ).toList();
    }
}