import java.util.*;

public class URI2137 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()){
            int len = in.nextInt();
            String s = in.nextLine();
            ArrayList<String> x = new ArrayList<>();
            while(len>0){
                x.add(in.nextLine());
                len--;
            }
            Collections.sort(x);
            for(int i = 0 ; i< x.size();i++){
                System.out.println(x.get(i));
            }
        }
    }
}
