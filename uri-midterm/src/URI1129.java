import java.util.Scanner;

public class URI1129 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int len = in.nextInt();
            if(len==0)
                break;
            for(int i = 0 ;i<len;i++){
                int a1 = in.nextInt();
                int a2 = in.nextInt();
                int a3 = in.nextInt();
                int a4 = in.nextInt();
                int a5 = in.nextInt();
                a1=(a1<=127)? (a1=1) : (a1=0);
                a2=(a2<=127)? (a2=1) : (a2=0);
                a3=(a3<=127)? (a3=1) : (a3=0);
                a4=(a4<=127)? (a4=1) : (a4=0);
                a5=(a5<=127)? (a5=1) : (a5=0);
                if(a1+a2+a3+a4+a5>1){
                    System.out.println("*");
                }
                else{
                    if(a1==1){
                        System.out.println("A");
                    }
                    if(a2==1){
                        System.out.println("B");
                    }
                    if(a3==1){
                        System.out.println("C");
                    }
                    if(a4==1){
                        System.out.println("D");
                    }
                    if(a5==1){
                        System.out.println("E");
                    }
                }
            }
        }
    }
}
