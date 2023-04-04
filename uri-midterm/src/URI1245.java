import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class URI1245 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            int[] right = new int[31];
            int[] left = new int[31];
            for(int i = 0 ; i <len;i++){
                int size = in.nextInt();    
                char leg =in.next().charAt(0);
                if(leg=='D'){
                    right[size-30]++;
                }
                else
                    left[size-30]++;
            }
            int res = 0;
            for(int i =0;i<=30;i++){
                res+=Math.min(right[i],left[i]);
            }
            System.out.println(res);
        }
    }
}
