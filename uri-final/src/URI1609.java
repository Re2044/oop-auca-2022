import java.util.Scanner;

public class URI1609 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ;i<n;i++){
            int m = in.nextInt();
            int ans = 0;
            int [] arr = new int[10001];
            for(int j = 0 ;j<m;j++){
                int k = in.nextInt();
                arr[k]++;
                if(arr[k]==1)
                    ans++;
            }
            System.out.println(ans);
        }
    }
}
