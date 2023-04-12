import java.util.Scanner;

public class URI2694 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ss = in.nextLine();
        for(int i = 0 ; i <n;i++){
            String s = in.nextLine();
            //System.out.println(s.substring(2,4)+s.substring(5,8)+s.substring(11,13));
            int sum = Integer.parseInt(s.substring(2,4))+Integer.parseInt(s.substring(5,8))+Integer.parseInt(s.substring(11,13));
            System.out.println(sum);
        }
    }
}
