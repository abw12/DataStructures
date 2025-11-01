package BasicPrograms;

public class ReverseStringVariant {

    public static void main(String[] args) {
        //Write a program for Reverse a string without affecting special characters
// (Input:   str = "Wal@ma&rt"  Output:  str = "tra@ml&aW")

        String  s = "Wal@ma&rt";
        char[] chArr = s.toCharArray();
        int l=0;
        int r = s.length()-1;
        while(l <= r){
            if(Character.isAlphabetic(chArr[l]) && Character.isAlphabetic(chArr[r])){
                char temp = chArr[l];
                chArr[l]=chArr[r];
                chArr[r]=temp;
                l++;
                r--;
            }else if(!Character.isAlphabetic(chArr[l])){
                l++;
            }else{
                r--;
            }
        }
        StringBuilder sb =new StringBuilder();
        for(Character ch : chArr){
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
