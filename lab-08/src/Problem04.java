import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        File targetFile = new File(args[1]);
        if (targetFile.exists()) {
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }
        try (
             Scanner in = new Scanner(sourceFile);
             PrintWriter out = new PrintWriter(targetFile);
        )   {
                while(in.hasNext()){
                    String s = in.nextLine();
                    String res = s.replaceAll(args[2],args[3]);
                    out.println(res);
                }
            }
    }
}
