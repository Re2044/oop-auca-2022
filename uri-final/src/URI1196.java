import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URI1196 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String qwe = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";

        Map<Character,Integer> dict= new HashMap<Character,Integer>();

        for(int i = 0 ;i<qwe.length();i++){
            dict.put(qwe.charAt(i),i);
        }
        String res = "";
        for (int i = 0 ;i<s.length();i++){
            if(s.charAt(i)!=' '){

                //System.out.println(qwe.charAt(dict.get(s.charAt(i))-1));
                res+=qwe.charAt(dict.get(s.charAt(i))-1);
            }
            else
                res+=" ";
        }
        System.out.println(res);
    }
}
