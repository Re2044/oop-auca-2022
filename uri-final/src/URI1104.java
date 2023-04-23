import java.util.Scanner;

public class URI1104 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while (true){
            int n = in.nextInt();
            int m = in.nextInt();
            if(n==0)
                break;
            int [] a = new int[n];
            int [] b = new int[m];
            int [] c = new int[100001];
            int [] d = new int[100001];
            for(int i  =  0; i <n;i++){
                a[i]=in.nextInt();
                c[a[i]]++;
            }
            for(int i  =  0; i <m;i++){
                b[i]=in.nextInt();
                d[b[i]]++;
            }
            int cnt = 0;
            int cnt1 = 0;
            for(int i = 1;i<=100000;i++){
                if(c[i]>0 && d[i]==0){
                    cnt++;
                }

                else if (c[i]==0 && d[i]>0){
                    cnt1++;
                }
            }
            System.out.println(Math.min(cnt,cnt1));
        }
    }
}
