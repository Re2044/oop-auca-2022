import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem02 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.nextLine();
        for(int i =0;i<n;i++){
            String s = in.nextLine();
            String res = "";
            for(int j = 0 ; j<s.length();j++){
                if((int)s.charAt(j)>=65 && (int)s.charAt(j)<=90)
                    res+=(char)(s.charAt(j)+3);
                else if((int)s.charAt(j)>=97 && (int)s.charAt(j)<=122)
                    res+=(char)(s.charAt(j)+3);
                else
                    res+=s.charAt(j);
            }
            String res1="";
            for(int j = s.length()-1;j>=0;j--){
                res1+=res.charAt(j);
            }
            String res2 = "";
            for(int j = 0;j<s.length()/2;j++){
                res2+=res1.charAt(j);
            }
            for(int j =s.length()/2;j<s.length();j++){
                res2+=(char)(res1.charAt(j)-1);
            }
            System.out.println(res2);
        }
    }
}
