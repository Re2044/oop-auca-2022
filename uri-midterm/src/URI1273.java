import java.util.Scanner;

public class URI1273 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int len = in.nextInt();
            if(len==0){
                break;
            }
            String s = in.nextLine();
            String[] ans = new String[len];
            int maxx = -1;
            for(int i= 0 ;i<len;i++){
                ans[i] = in.nextLine();
                if(ans[i].length()>maxx)
                    maxx=ans[i].length();
            }
            for(int i = 0;i<len;i++){
                for(int j = ans[i].length();j<maxx;j++)
                    System.out.print(' ');
                System.out.println(ans[i]);
            }
            System.out.println();
        }
    }
}
