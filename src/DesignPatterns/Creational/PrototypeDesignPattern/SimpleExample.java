package DesignPatterns.Creational.PrototypeDesignPattern;

// prototype interface
interface Enemy  extends Cloneable{
    Enemy clone();
}

// concrete class
class Orc implements Enemy{

    private String weapon;

    public Orc(String weapon){
        this.weapon=weapon;
    }
    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }


    @Override
    public Orc clone() {
        try{
            return (Orc) super.clone(); //shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Orc with weapon: " + weapon;
    }
}

public class SimpleExample {
    public static void main(String[] args) {
        Orc enemy1 = new Orc("Arrow");
        Orc enemy2 = enemy1.clone();
        enemy2.setWeapon("Gun");
        System.out.println(enemy1);
        System.out.println(enemy2);

    }
}
