import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class URI1255 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String y = in.nextLine();
        for(int i = 0;i<n;i++){
            String x = in.nextLine();
            int [] abc = new int[26];
            String alp = "abcdefghijklmnopqrstuvwxyz";
            x=x.toLowerCase();
            for(int j = 0;j<x.length();j++){

                if(x.charAt(j)-'a'<=25 && x.charAt(j)-'a'>=0)
                    abc[x.charAt(j)-'a']++;
            }
            int maxx =-1;
            for(int j = 0;j<26;j++){
                if(abc[j]>maxx){
                    maxx=abc[j];
                }
            }
            String res = "";
            for(int j = 0;j<26;j++){
                if(abc[j]==maxx){
                    res+=alp.charAt(j);
                }
            }
            System.out.println(res);
        }
    }
}
