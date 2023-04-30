import java.util.Scanner;

public class URI1553 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            int k = in.nextInt();
            if(n==0)
                break;
            int ans = 0;
            int [] freq = new int[101];
            for(int i = 0; i<n;i++){
                int x = in.nextInt();
                freq[x]++;
            }
            for(int i = 1;i<=100;i++){
                if(freq[i]>=k)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
