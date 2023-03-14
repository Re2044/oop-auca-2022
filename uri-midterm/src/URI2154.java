import java.util.Scanner;

public class URI2154 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int len = in.nextInt();
            String y = in.nextLine();
            String []ins = (in.nextLine()).split(" \\+ ");
            int []fr = new int[len];
            int []ft = new int[len];
            for(int i = 0;i<len;i++){
                String[] t = ins[i].split("x");
                int coef = Integer.parseInt(t[0]);
                int voed = Integer.parseInt(t[1]);
                fr[i]=coef*voed;
                ft[i]=voed-1;
            }
            for(int i = 0 ;i<len;i++){
                if(i!=len-1){
                    if(ft[i]!=1)
                        System.out.print(fr[i]+"x"+ft[i]+" + ");
                    else
                        System.out.print(fr[i]+"x"+" + ");
                }

                else{
                    if(ft[i]!=1)
                        System.out.println(fr[i]+"x"+ft[i]);
                    else
                        System.out.println(fr[i]+"x");
                }

            }
        }
    }
}
