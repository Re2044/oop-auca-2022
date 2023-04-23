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
                if(n>=0 && isSquare[n]){
                    System.out.println("YES");
                }
                else
                    System.out.println("NO");
            }
            catch (NoSuchElementException ex){
                break;
            }

        }
    }
}
