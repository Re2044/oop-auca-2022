import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class URI1609 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ;i<n;i++){
            int m = in.nextInt();
            int ans = 0;
            Set<Integer> arr = new HashSet<>();
            for(int j = 0 ;j<m;j++){
                int k = in.nextInt();
                arr.add(k);
            }
            System.out.println(arr.size());
        }
    }
}
