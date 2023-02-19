import java.util.Scanner;

public class URI1514 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            if(n==0 && m==0){
                break;
            }
            int[] problems = new int[m];
            int[] contestants = new int[n];
            for(int i = 0 ; i <n; i++){
                for(int j = 0;j<m;j++){
                    int curr = in.nextInt();
                    problems[j]+=curr;
                    contestants[i]+=curr;
                }
            }
            int cnt = 1;
            int cnt1 = 1;
            for(int i = 0 ; i <n;i++){
                if(contestants[i]==m){
                    cnt=0;
                }
                if(contestants[i]==0){
                    cnt1=0;
                }
            }
            int res = cnt+cnt1;
            cnt = 1;
            cnt1 =1;
            for(int i = 0 ; i <m;i++){
                if(problems[i]==n){
                    cnt=0;
                }
                if(problems[i]==0){
                    cnt1=0;
                }
            }
            System.out.println(res+cnt+cnt1);
        }
    }
}
