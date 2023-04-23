import java.util.NoSuchElementException;
import java.util.Scanner;

public class URI1558 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        boolean [] isSquare = new boolean[10001];
        for(int i = 0 ; i<=1000;i++){
            for(int j = 0;j<=1000;j++){
                if(i*i+j*j<=10000)
                    isSquare[i*i+j*j]=true;
            }
        }
        while(in.hasNextLine()){
            try{
                int n = in.nextInt();
                if(isSquare[n]==true){
                    System.out.println("Yes");
                }
                else
                    System.out.println("No");
            }
            catch (NoSuchElementException ex){
                break;
            }

        }
    }
}
