

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class URI2174 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String y = in.nextLine();
        Set<String> k= new HashSet<>();
        for(int i = 0; i<len;i++){
            String s = in.nextLine();
            k.add(s);
        }
        System.out.println("Falta(m) "+(151-k.size())+" pomekon(s).");
    }
}
