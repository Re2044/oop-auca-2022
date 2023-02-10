import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<String,Integer>k  = new HashMap<String, Integer>();
        k.put("0",6);
        k.put("1",2);
        k.put("2",5);
        k.put("3",5);
        k.put("4",4);
        k.put("5",5);
        k.put("6",6);
        k.put("7",3);
        k.put("8",7);
        k.put("9",6);
        String s1 = in.nextLine();
        for(int i =0;i<n;i++){
            Integer sum = 0;
            String s = in.nextLine();
            for(int j = 0;j<s.length();j++){
                sum+=k.get(String.valueOf(s.charAt(j)));
            }
            System.out.println(sum+" leds");
        }
    }
}
