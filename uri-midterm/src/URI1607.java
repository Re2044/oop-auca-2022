import java.util.Scanner;

public class URI1607 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String y = in.nextLine();
        while(n>0){
            String tr = in.nextLine();
            String[] ins= tr.split(" ");
            String a = ins[0];
            String b = ins[1];
            int res =0;
            for(int i = 0;i<a.length();i++){
                int f = a.charAt(i)-'a';
                int s = b.charAt(i)-'a';
                int plus = 0;
                if(s<f){
                    plus = 26+s-f;
                }
                else{
                    plus = s-f;
                }
                res+=plus;
            }
            System.out.println(res);
            n--;
        }
    }
}
