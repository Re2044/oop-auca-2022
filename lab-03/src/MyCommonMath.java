import java.math.BigInteger;

public class MyCommonMath {
    public static int lcd(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public static BigInteger lcd(BigInteger a,BigInteger b){
        return (a.multiply(b)).divide(gcd(a,b));
    }
    public static int gcd(int a, int  b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
    public static BigInteger gcd(BigInteger a,BigInteger b){
        if (b.equals("0")) return a;
        else return gcd(b, a.mod(b));
    }
}
