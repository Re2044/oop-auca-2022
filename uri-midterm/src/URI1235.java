import java.util.Scanner;

public class URI1235 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt() ;
        String s = in.nextLine();
        for(int i =0;i<len;i++) {
            String curr = in.nextLine();
            StringBuilder first = new StringBuilder();
            first.append(curr.substring(0,curr.length()/2));
            first.reverse();
            StringBuilder second = new StringBuilder();
            second.append(curr.substring(curr.length()/2,curr.length()));
            second.reverse();
            System.out.println(first.append(second));
        }
    }
}
