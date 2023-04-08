import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1768 {
    public static  void main(String args[]){
        Scanner in = new Scanner(System.in);
        int k = 0;
        while(in.hasNextLine()){
            int l = Integer.parseInt(in.nextLine());
            int x = l/2+1;
            for(int i = 1;i<=x;i++){
                for(int j = i-1;j<l/2;j++){
                    System.out.print(" ");
                }
                int r = 2*i-1;
                for(int j = 1;j<=r;j++){
                    System.out.print("*");
                }

                System.out.println();
            }
            for(int j = 1;j<=l/2;j++){
                System.out.print(" ");
            }
            System.out.println("*");
            for(int j = 0;j<(l-3)/2;j++){
                System.out.print(" ");
            }
            System.out.println("***");

            System.out.println();
        }


    }
}
