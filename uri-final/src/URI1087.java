import java.util.Scanner;

public class URI1087 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            int xq=in.nextInt();
            int yq = in.nextInt();
            int xf = in.nextInt();
            int yf = in.nextInt();
            if(xq ==0){
               break;
            }
            else{
                if(xq==xf || yq==yf){
                    if(xq==xf && yq==yf)
                        System.out.println(0);
                    else
                        System.out.println(1);
                }
                else if(Math.abs(xq-xf)==Math.abs(yq-yf)){
                    System.out.println(1);
                }
                else
                    System.out.println(2);
            }
        }
    }
}
