import java.util.ArrayList;
import java.util.Random;

public class Problem04 {
    public static void main(String args[]){
        ArrayListIntOptimized a = new ArrayListIntOptimized();
        ArrayList<Integer> b = new ArrayList<Integer>();
        Random rand = new Random();
        long begin = System.nanoTime();
        for(int i= 0; i<10000;i++){
            a.add(rand.nextInt(0,200000));

        }
        System.out.println(System.nanoTime()-begin);
        begin = System.nanoTime();
        for(int i = 0;i<10000;i++){
            b.add(rand.nextInt(0,200000));
        }
        System.out.println(System.nanoTime()-begin);
        for(int i= 0; i<10000;i++){
            a.add(i,rand.nextInt(0,200000));

        }
        System.out.println(System.nanoTime()-begin);
        begin = System.nanoTime();
        for(int i = 0;i<10000;i++){
            b.add(i,rand.nextInt(0,200000));
        }
        System.out.println(System.nanoTime()-begin);
        for(int i= 0; i<10000;i++){
            a.remove(i);

        }
        System.out.println(System.nanoTime()-begin);
        begin = System.nanoTime();
        for(int i = 0;i<10000;i++){
            b.remove(i);
        }
        System.out.println(System.nanoTime()-begin);
    }
}
