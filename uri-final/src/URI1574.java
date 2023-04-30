import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1574 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        for(int t = 0;t<len;t++){
            int n = in.nextInt();
            //System.out.println(n);
            int curr = 0;
            int [] pos = new int[n];
            String s= in.nextLine();
            for(int p = 0 ;p<n;p++){

                String x = in.nextLine();
                // System.out.println(x);
                if(x.equals("LEFT")){
                    pos[p]=-1;
                    curr--;
                }
                else if(x.equals("RIGHT")){
                    pos[p]=1;
                    curr++;
                }
                else{
                    String num = x.substring(8);
                    //System.out.println(num);
                    int ind = Integer.parseInt(num)-1;
                    pos[p]=pos[ind];
                    curr+=pos[p];
                }
            }
            System.out.println(curr);
        }
    }
}
