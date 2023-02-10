import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem04 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.nextLine();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i =0;i<n;i++){
            String s = in.next();
            String s2 = in.next();
            String res ="";
            for(int j = 0;j<Math.min(s.length(),s2.length());j++){
                res+=s.charAt(j);
                res+=s2.charAt(j);
            }
            if(s.length()>s2.length()){
                for(int j = s2.length();j<s.length();j++){
                    res+=s.charAt(j);
                }
            }
            else if(s2.length()>s.length()){
                for(int j = s.length();j<s2.length();j++){
                    res+=s2.charAt(j);
                }
            }
            System.out.println(res);
        }
    }
}
