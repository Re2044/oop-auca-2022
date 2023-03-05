import java.util.Scanner;

public class URI2242 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String res = "";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                res+=s.charAt(i);
            }
        }
        String res1="";
        for(int i = res.length()-1;i>=0;i--){
            res1+=res.charAt(i);
        }
        if(res.equals(res1)){
            System.out.println("S");
        }
        else{
            System.out.println("N");
        }
    }
}
