import java.util.Scanner;

public class URI1237 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String first = in.nextLine();
            String second = in.nextLine();
            int res = 0;
            int len = Math.min(first.length(),second.length());
            for(int i = len-1;i>0;i--){
                for(int j =0 ;j < first.length()-i+1;j++){
                    String subst = first.substring(j,j+i);
                    if(second.contains(subst)){
                        res = Math.max(res,i);
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
