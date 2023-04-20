import java.util.*;

public class URI1318 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int len = in.nextInt();
            int m = in.nextInt();
            if(len==0)
                break;
            int[] k = new int [10001];
            int ans = 0;

            for(int i = 0 ; i < m;i++){
                int x = in.nextInt();
                k[x]++;
            }
            for(var i = 1;i<=len;i++){
                if(k[i]>1){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
