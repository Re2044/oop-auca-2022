import java.util.Scanner;

public class URI2651 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for(int i = 0 ; i<s.length()-4;i++){
            var s1 = s.substring(i,i+5);
            if(s1.toUpperCase().equals("ZELDA")){
                System.out.println("Link Bolado");
                System.exit(0);
            }
        }
        System.out.println("Link Tranquilo");
    }
}
