package BasicPrograms;

class Netwest extends Practise{

    public void print(int num){
        System.out.println("print int method in subclass netwest " + num);
    }

}
public class Practise {
        //if we uncomment this below method then method overriding concept is applied where below we creating an obj p of Netwest class
        //which also have print method with(int num) signature
        //but  the object creation process happen at run-time and below method is  commented the below code will print the
        // print(Integer num) method instead of subclass Netwest print(int num) method

//    public void print(int num){
//        System.out.println("print int method in parent class " + num);
//    }

    public void print(Integer num){
        System.out.println("print Integer method in parent class " + num);
    }

    public static void main(String[] args) {
        Practise p = new Netwest();
        p.print(1);
    }
}
