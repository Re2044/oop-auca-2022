import java.util.Scanner;

public class URI1332 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s= in.nextLine();
        for(int i = 0 ; i <len;i++){
            String ins = in.nextLine();

            if(ins.length()==5){
                System.out.println(3);
            }
            else{
                int cnt1 = 0;
                int cnt2 = 0;
                if(ins.charAt(0)!='t'){
                    cnt1++;
                }
                if(ins.charAt(1)!='w'){
                    cnt1++;
                }
                if(ins.charAt(2)!='o'){
                    cnt1++;
                }
                if(ins.charAt(0)!='o'){
                    cnt2++;
                }
                if(ins.charAt(1)!='n'){
                    cnt2++;
                }
                if(ins.charAt(2)!='e'){
                    cnt2++;
                }
                if(cnt1<=1){
                    System.out.println(2);
                }
                else{
                    System.out.println(1);
                }
            }
        }
    }
}
