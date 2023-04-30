import java.util.ArrayList;
import java.util.Scanner;

public class URI1031 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(true){
            int x= in.nextInt();
            if(x==0)
                break;
            ArrayList<Integer> arr = new ArrayList<>();

            for(int m = 1;m<=x;m++){
                for(int t =0;t<x;t++){
                    arr.add(t+1);
                }
                int curr = 0;
                while(arr.size()!=1){
                    arr.remove(curr);
                    curr+=m-1;
                    curr%=(arr.size());
                }
                if(arr.get(0)==13){
                    System.out.println(m);
                    break;
                }
                arr.remove(0);
                //System.out.println(arr.get(0));
            }
        }
    }
}
