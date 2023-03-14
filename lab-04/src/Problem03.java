import java.util.ArrayList;
import java.util.Scanner;

public class Problem03 {
    static String ArrayToString(ArrayListInt input){
        String result = "[";
        for(int i = 0;i<input.size();i++){
            if(i!=input.size()-1)
                result+=input.get(i)+", ";
            else
                result+=input.get(i)+"]";
        }
        return result;
    }
    static ArrayListInt Reverse(ArrayListInt input){
        ArrayListInt result = new ArrayListInt();
        for(int i = input.size() -1 ; i>=0;i--){
            result.add(input.get(i));
        }
        return result;
    }
    static ArrayListInt AddZero(ArrayListInt input){
        ArrayListInt result = new ArrayListInt();
        for(int i = 0 ; i<input.size();i++){
            if((input.get(i))%2==0)
                result.add(0);
            result.add(input.get(i));
        }
        return result;
    }
    static ArrayListInt DeleteOdds(ArrayListInt input){
        ArrayListInt result = new ArrayListInt();
        for(int i = 0 ; i<input.size();i++){
            if(input.get(i)%2!=1){
                result.add(input.get(i));
            }
        }
        return result;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        ArrayListInt array = new ArrayListInt();
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
        System.out.println(ArrayToString(array));
        System.out.println("After reversing:");
        System.out.println(ArrayToString(Reverse(array)));
        System.out.println("After insertions:");
        System.out.println(ArrayToString(AddZero(array)));
        System.out.println("After deletions:");
        System.out.println(ArrayToString(DeleteOdds(AddZero(array))));
    }
}
