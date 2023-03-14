
import java.util.ArrayList;
import java.util.Scanner;

public class Problem01 {
    static ArrayList<Integer> Reverse(ArrayList<Integer>input){
        ArrayList<Integer>result = new ArrayList<Integer>(input.size());
        for(int i = input.size() -1 ; i>=0;i--){
            result.add(input.get(i));
        }
        return result;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer>array = new ArrayList<Integer>();
        while(in.hasNextLine()){
            try{
                int x = in.nextInt();
                array.add(x);
            }
            catch(Exception ex){
                break;
            }


        }
        System.out.println("Before reversing:");
        System.out.println(array.toString());
        System.out.println("After reversing:");
        System.out.println(Reverse(array).toString());

    }
}
