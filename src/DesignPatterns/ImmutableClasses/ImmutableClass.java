package DesignPatterns.ImmutableClasses;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Always remember that your instance variables will be either mutable or immutable.
 * Identify them and return new objects with copied content for all mutable objects.
 * Immutable variables can be returned safely without extra effort.
 * */
public final class  ImmutableClass {
    /**
     * String class is immutable as it also does not provide setter to change its content
     * */
    private final String immutableField1;
    /**
     * Integer class is immutable as it does not provide any setter to change its content
     * */
    private final Integer immutabaleField2;
    /**
     * Date class is mutable as it provide setters to change various date/time parts
     * */
    private final Date muttableField;

    private final Map<String,String> map;


    //Default private constructor will ensure no unplanned construction of class
    //a private constructor is not strictly required to make a class immutable in Java,
    // but it helps centralize and control object construction, which is sometimes desirable for advanced scenarios
    private ImmutableClass(String field1,Integer field2 ,Date date,Map<String,String> map){
        this.immutableField1=field1;
        this.immutabaleField2=field2;
        this.muttableField=new Date(date.getTime());
        this.map=new HashMap<>(map);
    }

    //Factory method to store object creation logic in single place
    public static ImmutableClass getImmutableInstance(String field1,Integer field2,Date date,Map<String,String> map){
        return new ImmutableClass(field1,field2,date,map);
    }
    /**
     * String class is also immutable so we can return the instance variable as it is
     * */
    public String getImmutableField1() {
        return this.immutableField1;
    }

    /**
     * Integer class is immutable so we can return the instance variable as it is
     * */
    public Integer getImmutabaleField2() {
        return this.immutabaleField2;
    }
    /**
     * Date class is mutable so we need a little care here.
     * We should not return the reference of original instance variable.
     * Instead a new Date object, with content copied to it, should be returned.
     * */
    public Date getMuttableField(){
        return new Date(this.muttableField.getTime());
    }

    public Map<String,String> getMap(){
        return new HashMap<>(this.map);
    }
//


    @Override
    public String toString() {
        return "ImmutableClass{" +
                "immutableField1='" + immutableField1 + '\'' +
                ", immutabaleField2=" + immutabaleField2 +
                ", muttableField=" + muttableField +
                ", map=" + map +
                '}';
    }
}
/* NOTE::
An immutable class is defined by all its fields being final and private, not exposing any setters or mutators,
and not returning references to mutable internal objects. Public constructors are permitted in most immutable classes;
this does not compromise immutability as long as state cannot be changed after construction.*/
