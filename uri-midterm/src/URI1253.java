import java.util.Scanner;

public class URI1253 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = in.nextLine();
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(int i =0;i<n;i++){
            String s = in.nextLine();

            int num = Integer.parseInt(in.nextLine());
            String res = "";
            for(int j = 0 ; j<s.length();j++){
                int pos = (int)s.charAt(j)-65;
                if(pos-num<0){
                    res+=abc.charAt(26+pos-num);
                }
                else
                    res+=abc.charAt((pos-num));
            }
            System.out.println(res);
        }
    }
}
