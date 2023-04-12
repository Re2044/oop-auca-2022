import java.util.Scanner;

public class URI1632 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();
        while(n>0){
            String curr = in.nextLine();
            int ans = 1;
            for(int i = 0;i<curr.length();i++){
                if(Character.toUpperCase(curr.charAt(i))=='A' || Character.toUpperCase(curr.charAt(i))=='E' || Character.toUpperCase(curr.charAt(i))=='I' || Character.toUpperCase(curr.charAt(i))=='O'){
                    ans = ans *3;
                }
                else
                    ans*=2;
            }
            System.out.println(ans);
            n--;
        }
    }
}