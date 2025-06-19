package ArraysPractise;

public class AccentureQuestion
{

    public static void main(String[] args) {

        String name="my name is abhishek";
        String[] ans=name.split(" ");
        String temp=ans[0];
        int len=ans.length;
        ans[0]=ans[len-1];
        ans[len-1]=temp;
        name=String.join(" ",ans);

        System.out.println(name);
    }
}
