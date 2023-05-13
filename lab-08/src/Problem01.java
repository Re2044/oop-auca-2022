import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem01 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean isInput = true;
        while(isInput){
            try{
                System.out.print("Enter an integer: ");
                int num = in.nextInt();
                System.out.println("The number entered is " + num);
                isInput = false;
            }
            catch (InputMismatchException ex){
                System.out.println("Try again. (" +"Incorrect input: an integer is required)");
                in.nextLine();
            }
        }
    }
}
