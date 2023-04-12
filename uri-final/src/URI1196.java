import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URI1196 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            String qwe = "`1234567890-=QWERTYUIOP[]\\\\ASDFGHJKL;'ZXCVBNM,./";
            for (int i = 0 ;i<s.length();i++){
                int index = qwe.indexOf(s.charAt(i));
                if(index!=-1){
                    System.out.print(qwe.charAt(index-1));
                }
                else{
                    System.out.print(s.charAt(i));
                }
            }
            System.out.println();
        }


    }
}
