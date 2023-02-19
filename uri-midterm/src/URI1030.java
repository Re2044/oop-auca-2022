import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class URI1030 {
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        int len = in.nextInt();
        BitSet arr = new BitSet(10000);
        for(int i = 0 ; i < len; i++){
            int n = in.nextInt();
            int m = in.nextInt();
            int currPos = 0 ;
            int algPos = 1;
            arr.set(0,n,true);
            while(arr.cardinality()>1){
                while(algPos<=m-1){
                    currPos++;
                    currPos%=n;
                    if(arr.get(currPos)==true){
                        algPos++;
                    }
                }
                algPos = 1;
                arr.set(currPos,false);
                currPos++;
                currPos%=n;
                if(arr.nextSetBit(currPos)!=-1){
                    currPos=arr.nextSetBit(currPos);
                }
                else
                    currPos = arr.nextSetBit(0);
            }
            System.out.println("Case "+(i+1)+": "+(currPos+1));
        }
    }
}
