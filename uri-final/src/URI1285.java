import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1285 {
    public static boolean checkValue(int x){
        int [] used = new int[10];
        while(x>0){
            int a = x%10;
            if(used[a]==0){
                used[a]++;
            }
            else{
                return false;
            }
            x/=10;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            try{
                int n = in.nextInt();
                int m = in.nextInt();
                int ans = 0;
                for(int i  = n;i<=m;i++){
                    if(checkValue(i)){
                        ans++;
                    }
                }
                System.out.println(ans);
            }
            catch (NoSuchElementException x){
                break;
            }
        }
    }
}
