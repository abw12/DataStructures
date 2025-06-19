package BasicPrograms;

public class HCL extends myclass {

    static  {
        int x =20, y=50;
        System.out.println(x+y);
    }

    public static void main(String[] args) {
        HCL obj = new HCL();
    }

}

//since static variable/block belongs to the class level
class myclass{
    static int num=10;
    static {
        int a=10,b=20;
        num=b;
        System.out.println(a+b);
    }
    public myclass(){
        System.out.println(++num);
    }

}

