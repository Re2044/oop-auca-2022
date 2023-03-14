import java.util.ArrayList;
import java.util.Scanner;

public class Problem02 {
    static ArrayList<Integer> AddZero(ArrayList<Integer> input){
        ArrayList<Integer>result = new ArrayList<Integer>();
        for(int i = 0 ; i<input.size();i++){
            if((input.get(i))%2==0)
                result.add(0);
            result.add(input.get(i));
        }
        return result;
    }
    static ArrayList<Integer> DeleteOdds(ArrayList<Integer>input){
        ArrayList<Integer>result = new ArrayList<Integer>();
        for(int i = 0 ; i<input.size();i++){
            if(input.get(i)%2!=1){
                result.add(input.get(i));
            }
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
        System.out.println("After insertions:");
        System.out.println(AddZero(array).toString());
        System.out.println("After deletions:");
        System.out.println(DeleteOdds(AddZero(array)).toString());
    }
}
