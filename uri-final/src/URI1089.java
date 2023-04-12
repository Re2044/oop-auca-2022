import java.util.Scanner;

public class URI1089 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int n = in.nextInt();
            if(n==0)
                break;
            int [] arr = new int[n];
            for(int i = 0 ; i<n;i++){
                arr[i] = in.nextInt();
            }
            int ans = 0;
            if(arr[0]>arr[1] && arr[0]>arr[n-1]){
                ans++;
            }
            if(arr[0]<arr[1] && arr[0]<arr[n-1]){
                ans++;
            }
            if(arr[n-1]>arr[n-2] && arr[n-1]>arr[0]){
                ans++;
            }
            if(arr[n-1]<arr[n-2] && arr[n-1]<arr[0]){
                ans++;
            }
            for(int i = 1;i<n-1;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    ans++;
                }
                else if (arr[i]<arr[i-1] && arr[i]<arr[i+1]){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
