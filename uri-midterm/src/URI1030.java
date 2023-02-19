import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class URI1030 {
    static void func(List<Integer>alive, int step, int currPos)
    {
        if (alive.size() == 1) {
            System.out.println(alive.get(0));
        }
        else{
            currPos = ((currPos + step -1) % alive.size());
            alive.remove(currPos);
            func(alive, step , currPos);
        }


    }
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int len = in.nextInt();
        for(int i = 0 ; i < len; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> alive = new ArrayList<>(n);
            for(int j = 1;j<=n;j++){
                alive.add(j);
            }
            func(alive,m,0);
        }
    }
}
