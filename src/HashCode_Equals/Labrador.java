package HashCode_Equals;

public class Labrador extends Dog{

    public Labrador(String name) {
        super(name);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        //below line demonstrate if there are subclasses of Dog class then we have to explicitly compare it with the dog class name so that equals method perform efficiently
////        if (o == null || getClass() != o.getClass()) return false;
//        //custom way to check the string name equality of the class dog.name
//        if( o instanceof Labrador){
//            String objName=((Labrador) o).getName();
//            return  this.getName().equals(objName);
//        }
//        return  false;
//    }
}
