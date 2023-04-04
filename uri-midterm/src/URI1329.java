import java.util.Scanner;

public class URI1329 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            int size = in.nextInt();
            if(size==0)
                break;
            int zero = 0;
            int one = 0;
            for(int i = 0 ; i<size;i++){
                int x = in.nextInt();
                if(x==0)
                    zero++;
                else
                    one++;
            }
            System.out.println("Mary won "+zero+" times and John won "+one+" times");
        }
    }
}
