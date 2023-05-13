import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem05 {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java DeleteText sourceFile");
            System.exit(1);
        }
        File sourceFile = new File(args[1]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        ArrayList<String>a = new ArrayList<String>();
        try (Scanner in = new Scanner(sourceFile))  {
            while(in.hasNext()){
                String s = in.nextLine();
                String res = s.replaceAll(args[0],"");
                a.add(res);
            }
        }
        try(PrintWriter out = new PrintWriter(sourceFile)){
            for(int i = 0 ; i <a.size();i++){
                out.append(a.get(i));
            }
        }
    }
}
