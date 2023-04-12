import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URI1196 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            var arr = s.toCharArray();
            String qwe = "`1234567890-=QWERTYUIOP[]\\\\ASDFGHJKL;'ZXCVBNM,./";
            var alpha = qwe.toCharArray();
            for (int i = 0 ;i<arr.length;i++){
                int index = qwe.indexOf(arr[i]);
                if(index!=-1){
                    System.out.print(alpha[index-1]);
                }
                else{
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }


    }
}
