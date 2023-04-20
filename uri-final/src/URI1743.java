import java.util.Scanner;

public class URI1743 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int [] first = new int[5];
        int [] second = new int[5];
        for(int i = 0 ; i <5; i++){
           first[i] = in.nextInt();
        }
        for(int i = 0 ; i <5; i++){
            second[i] = in.nextInt();
        }
        boolean flag = true;
        for(int i = 0;i<5;i++){
            if(first[i]==second[i]){
                flag = false;
            }
        }
        if(flag==false){
            System.out.println("N");
        }
        else
            System.out.println("Y");
    }
}
