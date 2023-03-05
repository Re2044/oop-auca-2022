import java.util.Scanner;

public class URI1257 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ;i<n;i++){
            int t = in.nextInt();
            int sum = 0;
            String y = in.nextLine();
            for(int j = 0;j<t;j++){
                String s = in.nextLine();
                for(int k = 0;k<s.length();k++){
                    sum+=s.charAt(k)-'A'+j+k;
                }
            }
            System.out.println(sum);
        }
    }
}
