import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class URI1581 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        while(len>0){
            int x = in.nextInt();
            String s = in.nextLine();
            String prev = "";
            int cnt = 0;
            while(x>0){
                String ins = in.nextLine();
                if(ins.equals(prev)==false) {
                    prev = ins;
                    cnt++;
                }
                x--;
            }
            if(cnt>1){
                System.out.println("ingles");
            }
            else
                System.out.println(prev);
            len--;
        }
    }
}
