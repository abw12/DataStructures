package HashCode_Equals;

import java.util.Objects;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //we make this final to make sure that no subclass override this method and
    // we have consistent behaviour of equals method across the ref of the Dog class
    @Override
    public final boolean equals(Object that) {
        if (this == that) return true;
        //below line demonstrate if there are subclasses of Dog class then we have to explicitly compare
        // it with the dog classname so that equals method perform efficiently
        if (that == null || this.getClass() != that.getClass()) return false;
        //custom way to check the string name equality of the class dog.name
        if( that instanceof Dog){
            String objName=((Dog) that).getName();
            return this.name.equals(objName);
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
