package BasicPrograms;


//Program to convert time from 12 hour to 24 hour format
//it takes a time and space complexity of O(1)
public class TimeConversion {
    public static void main(String[] args) {
        String s = "10:12:33PM";
        System.out.println(convertTime(s));
    }

    private static String convertTime(String s) {
        int h1 = (int)s.charAt(1) - '0';
        int h2 = (int)s.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10 );
        StringBuffer output = new StringBuffer();
        //for AM
        if(s.charAt(8) == 'A'){

            if(hh == 12){
                output.append("00");
                for(int i=2 ; i<=7 ; i++ ){
                    output.append(s.charAt(i));
                }
            }else{
                for(int i=0 ; i<=7 ; i++ ){
                    output.append(s.charAt(i));
                }
            }

        }
        //for PM
      else{
            if(hh == 12){
                output.append("12");
                for(int i=2 ; i<=7 ; i++ ){
                    output.append(s.charAt(i));
                }
            }else{
                hh = hh +12;
                output.append(hh);
                for(int i=2; i<=7 ; i++ ){
                    output.append(s.charAt(i));
                }
            }

        }
        return output.toString();

    }
}
