import java.util.Scanner;

public class URI1171 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] cnt = new int [2001];
        for(int i = 0 ;i< len;i++){
            int x = in.nextInt();
            cnt[x]++;
        }
        for(int i = 1 ; i <=2000;i++){
            if(cnt[i]>=1){
                System.out.println(i+" aparece "+cnt[i]+" vez(es)");
            }
        }
    }
}
