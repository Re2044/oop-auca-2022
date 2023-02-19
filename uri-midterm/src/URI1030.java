import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class URI1030 {
    public static int func(int n, int k) {
        if (n == 1) {
            return 1;
        } else {
            return (func(n-1, k) + k-1) % n + 1;
        }
    }
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int len = in.nextInt();
        for(int i = 0 ; i < len; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case "+(i+1)+": "+(func(n,m)));
        }
    }
}
