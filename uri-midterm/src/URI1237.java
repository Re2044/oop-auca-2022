import java.util.Scanner;

public class URI1237 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String first = in.nextLine();
            String second = in.nextLine();
            int res = 0;
            int len = Math.min(first.length(),second.length());
            for(int i = len-1;i>=0;i--){
                for(int j =0 ;j < first.length()-i+1;j++){
                    String subst = first.substring(j,j+i);
                    for(int k = 0;k<second.length()-i+1;k++){
                        String sub = second.substring(k,k+i);
                       // System.out.println(subst + " " +sub);
                        if(subst.equals(sub)){
                            res = Math.max(res,i);
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
