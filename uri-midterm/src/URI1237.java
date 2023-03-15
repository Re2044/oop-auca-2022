import java.util.Scanner;

public class URI1237 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            String first = in.nextLine();
            String second = in.nextLine();
            int res = 0;
            int len = Math.min(first.length(),second.length());
            int l = 0;
            int r = len+1;
            while(l<=r){
                int mid = (l+r)/2;
                boolean flag= false;
                for(int j =0 ;j < first.length()-mid+1;j++){
                    String subst = first.substring(j,j+mid);
                    if(second.contains(subst)){
                        res = Math.max(res,mid);
                        flag=true;
                        l = mid+1;
                    }
                }
                if(flag==false){
                    r=mid-1;
                }
            }
            System.out.println(res);
        }
    }
}
