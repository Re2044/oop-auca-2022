import java.util.Scanner;

public class URI1300 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int n = in.nextInt();
            if(n%6==0){
                System.out.println("Y");
            }
            else
                System.out.println("N");
        }
    }
}
