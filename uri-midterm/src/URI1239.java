import java.util.Scanner;

public class URI1239 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            boolean flag = false;
            for(int i = 0 ;i<s.length();i++){
                if(s.charAt(i)=='_' && flag==false){
                    flag = true;
                    s =s.replaceFirst("_","<i>");
                }
                else if(s.charAt(i)=='_' && flag==true){
                    flag = false;
                    s =s.replaceFirst("_","</i>");
                }
            }
            flag = false;
            for(int i = 0 ;i<s.length();i++){
                if(s.charAt(i)=='*' && flag==false){
                    flag = true;
                    s =s.replaceFirst("\\*","<b>");
                }
                else if(s.charAt(i)=='*' && flag==true){
                    flag = false;
                    s = s.replaceFirst("\\*","</b>");
                }
            }
            System.out.println(s);
        }
    }
}
