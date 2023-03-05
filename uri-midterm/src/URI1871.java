import java.util.Scanner;

public class URI1871 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int x = in.nextInt();
            int y = in.nextInt();
            if(x==0 && y==0){
                break;
            }
            int res = x+y;
            String t = Integer.toString(res);
            String r ="";
            for(int i = 0 ;i<t.length();i++){
                if(t.charAt(i)!='0'){
                    r+=t.charAt(i);
                }
            }
            System.out.println(r);
        }
    }
}
