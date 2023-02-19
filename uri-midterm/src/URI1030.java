import java.util.BitSet;
import java.util.Scanner;

public class URI1030 {
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int len = in.nextInt();
        for(int i = 0 ; i < len; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            BitSet used = new BitSet(n);
            used.set(0,n,true);

            while(used.cardinality()!=1){
                for(int j = 0 ; j<n;j++){
                    if(j%m==0 && used.get(j)==true){
                        if(j+1<n && used.nextSetBit(j+1)!=-1)
                            used.set( used.nextSetBit(j+1),false);
                        else if(used.cardinality()!=1){
                            used.set(used.nextSetBit(0),false);
                        }
                        else
                            break;
                    }
                }

                // System.out.println(used.cardinality());
            }
            System.out.println(used.nextSetBit(0)+1);
          //  System.out.println(beg);
        }
    }
}
