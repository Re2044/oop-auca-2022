import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1768 {
    public static  void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int x;
            try{
                x = in.nextInt();
            }catch (NoSuchElementException ex){
                break;
            }

            for(int i = 1;i<=x;i+=2){
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
            for(int j = 0;j<(x-1)/2;j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for(int j = 0;j<(x-1)/2;j++){
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
