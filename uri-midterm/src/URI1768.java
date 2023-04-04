import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1768 {
    public static  void main(String args[]){
        Scanner in = new Scanner(System.in);
        int k = 0;
        while(in.hasNextLine()){
            int x = Integer.parseInt(in.nextLine());
            if(x==1){
                System.out.println(" * ");
                System.out.println(" * ");
                System.out.println("***");
                System.out.println();
            }
            else {
                for(int i = 0;i<x;i+=2){
                    for(int j = 0;j<(x-i)/2;j++){
                        System.out.print(" ");
                    }
                    for(int j = 0;j<i;j++){
                        System.out.print("*");
                    }
                    for(int j = 0;j<(x-i)/2;j++){
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                for(int j = 1;j<=x/2;j++){
                    System.out.print(" ");
                }
                System.out.print("*");
                for(int j = 1;j<=x/2;j++){
                    System.out.print(" ");
                }
                System.out.println();
                for(int j = 0;j<(x-3)/2;j++){
                    System.out.print(" ");
                }
                System.out.print("***");
                for(int j = 0;j<(x-3)/2;j++){
                    System.out.print(" ");
                }
                System.out.println();
                System.out.println();
            }

        }
    }
}
