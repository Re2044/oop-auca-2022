import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class URI1533 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int len = in.nextInt();
            int m = in.nextInt();
            if(len==0)
                break;

            int ans = 0;
            int maxx = -1;
            int ansx = 0;
            int prev = -1;
            ArrayList<Integer>arr = new ArrayList<>();
            for(int i = 0 ; i < len;i++){
                int x = in.nextInt();
                if(x>maxx){
                    int c = maxx;
                    int t = ansx;
                    ansx = i+1;
                    maxx = x;
                    prev = c;
                    ans = t;
                }
                else if(x>prev){
                    prev = x;
                    ans = i+1;
                }
            }
            System.out.println(ans);
        }
    }
}
