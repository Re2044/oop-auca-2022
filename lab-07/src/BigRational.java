import java.math.BigInteger;
import java.util.List;

public class BigRational implements Comparable {
    private static List<String> SymbolList = List.of("+","-","/","*",">=","<=","!=","=",">","<");
    private BigInteger BigZero = new BigInteger("0");
    private BigInteger numerator = BigZero;
    private BigInteger denominator = BigZero;
    static String Operation(BigRational first, BigRational second, String InputSymbol){
        first.Simplify();
        second.Simplify();
        int Compare = first.compareTo(second);
        switch(InputSymbol) {
            case "+":
                return BigRational.toString(first.add(second));
            case "-":
                return BigRational.toString(first.subtract(second));
            case "/":
                return BigRational.toString(first.divide(second));
            case "*":
                return BigRational.toString(first.multiply(second));
            case "<":
                if(Compare == -1) return "true";
                else return "false";
            case ">":
                if(Compare == 1) return "true";
                else return "false";
            case "=":
                if(Compare == 0) return "true";
                else return "false";
            case "!=":
                if(Compare != 0) return "true";
                else return "false";
            case ">=":
                if(Compare == 0 || Compare==1) return "true";
                else return "false";
            case "<=":
                if(Compare == 0 || Compare==-1) return "true";
                else return "false";
            default:
                throw new IllegalArgumentException("'"+InputSymbol+"' is not a valid operator.");
        }
    }
    public void ChangeDenominator(BigInteger NewDenominator){
        this.denominator=NewDenominator;
    }
    public void ChangeNumerator(BigInteger NewNumerator){
        this.numerator=NewNumerator;
    }
    public BigInteger GetNumerator(){return this.numerator;}
    public BigInteger GetDenominator(){return this.denominator;}

    public void Simplify(){
        BigInteger GCD = MyCommonMath.gcd(this.numerator,this.denominator);
        this.ChangeNumerator(this.numerator.divide(GCD));
        this.ChangeDenominator(this.denominator.divide(GCD));
        if(numerator.compareTo(BigZero)==1 && denominator.compareTo(BigZero)==-1){this.ChangeNumerator(numerator.negate());this.ChangeDenominator(denominator.negate());}
    }
    public BigRational(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        if (denominator.equals(BigZero) ) {
            throw new IllegalArgumentException("The denominator can't be equal to zero");
        }
        this.denominator = denominator;
        this.Simplify();
    }

    public BigRational add(BigRational other) {
        BigInteger NewDenominator = MyCommonMath.lcd(this.denominator,other.GetDenominator());
        BigInteger NewNominator =((NewDenominator.divide(this.denominator)).multiply(this.numerator)).add(( NewDenominator.divide(other.GetDenominator()) ).multiply( other.GetNumerator()));
        BigRational result = new BigRational(NewNominator, NewDenominator);
        result.Simplify();
        return result;
    }
    public BigRational subtract(BigRational other) {
        BigInteger NewDenominator = MyCommonMath.lcd(this.denominator, other.GetDenominator());
        BigInteger NewNominator = ( NewDenominator.divide(this.denominator)).multiply(this.numerator).subtract(NewDenominator.divide(other.GetDenominator()).multiply(other.GetNumerator()));
        BigRational result = new BigRational(NewNominator, NewDenominator);
        result.Simplify();
        return result;
    }
    public BigRational multiply(BigRational other) {
        this.Simplify();
        other.Simplify();
        BigInteger NewNumerator = this.numerator.multiply(other.GetNumerator());
        BigInteger NewDenominator = this.denominator.multiply(other.GetDenominator());
        var result = new BigRational(NewNumerator,NewDenominator);
        result.Simplify();
        return result;
    }

    public BigRational divide(BigRational other) {
        this.Simplify();
        other.Simplify();
        if(other.numerator.equals(BigZero)){
            throw new NumberFormatException("Division by zero is not allowed");
        }
        BigInteger NewNumerator = this.numerator.multiply(other.GetDenominator());
        var NewDenominator = this.denominator.multiply(other.GetNumerator());
        var result = new BigRational(NewNumerator,NewDenominator);
        result.Simplify();
        return result;
    }

    @Override
    public int compareTo(Object other) {
        BigRational Answer = this.subtract((BigRational) other);
        return Answer.GetNumerator().multiply(Answer.GetDenominator()).compareTo(BigZero);
    }

    static String toString(BigRational InputRational) {
        return InputRational.GetNumerator().toString() + "/" + InputRational.GetDenominator().toString();
    }
    static boolean CheckSymbol(String InputSymbol){
        if(SymbolList.contains(InputSymbol)){return true;} else{throw new IllegalArgumentException("'"+InputSymbol+"' is not a valid operator.");}
    }
    static BigRational parseBigRational(String InputString) {
        BigRational res ;
        if (InputString.length() ==0) {throw new IllegalArgumentException("Empty input");}
        String[] in = InputString.split("/");
        if (in.length != 2) {throw new IllegalArgumentException("Can't parse "+InputString+" as input.");}
        else{
            try{new BigInteger(in[0]);}
            catch(IllegalArgumentException ex){throw new IllegalArgumentException("Incorrect numerator input");}
            try{new BigInteger(in[1]);}
            catch(IllegalArgumentException ex){throw new IllegalArgumentException("Incorrect denominator input");}
            try {res = new BigRational(new BigInteger(in[0]),new BigInteger(in[1]));}
            catch (IllegalArgumentException ex) {throw new NumberFormatException(ex.getMessage());}
            return res;
        }
    }
    @Override
    public String toString(){
        return this.GetNumerator().toString() + "/" + this.GetDenominator().toString();
    }


}

