package DiffWayToCreateInstance;

import java.io.*;

public class UsingSerialization  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee emp1 = new Employee();
        Employee emp3 = new Employee();

        //Serialize
        //the below syntax is the example of try with resource block which is alternative way of closing a resource than using finally block
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"))) {
            out.writeObject(emp1);
        }

        //older way of using finally block to close a resource in java
        ObjectOutputStream out1=null;
        try{
            out1 =new ObjectOutputStream(new FileOutputStream("data.obj"));
            out1.writeObject(emp3);
        }
        finally{
            out1.close();
        }


        //deserialize
        Employee emp2;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"))){
            emp2=(Employee) in.readObject();
            emp2.setName("emp2");
            System.out.println(emp2.toString());

        }

    }

}
