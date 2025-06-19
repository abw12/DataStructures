package BasicPrograms;

class Student {

    private String name;
    private String phnNum;

    public Student (String name,String phnNum){
        this.name= name;
        this.phnNum=phnNum;
    }

    //this is called as copy constructor uisng which we can create a new copied instance of this class based on the object passed as argument
    public Student(Student second){
        this.name=second.name;
        this.phnNum=second.phnNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(String phnNum) {
        this.phnNum = phnNum;
    }
}


public class CopyConstructorExample {

    public static void main(String[] args) {
        //original student object
        Student st1 = new Student("abhishek","788546");
        System.out.println("Original Studnet object : "+ st1);
        Student st2 = new Student(st1);
        System.out.println("Student using copy constructor: " + st2);

        st2.setName("vedant");
        System.out.println("Modified Object :" + st1.getName());
        //this proove that st2 is pointing to the different address in the memory as st2. name is change but it doesn't reflect in st1
    }
}
