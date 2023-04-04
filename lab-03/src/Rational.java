import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rational {
    private static List<String> SymbolList = List.of("+","-","/","*",">=","<=","!=","=",">","<");
    private int numerator = 0;
    private int denominator = 0;

    static String Operation(Rational first, Rational second, String InputSymbol){
        first.Simplify();
        second.Simplify();
        int Compare = first.compareTo(second);
        switch(InputSymbol) {
            case "+":
                return Rational.toString(first.add(second));
            case "-":
                return Rational.toString(first.subtract(second));
            case "/":
                return Rational.toString(first.divide(second));
            case "*":
                return Rational.toString(first.multiply(second));
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
    public void ChangeDenominator(int NewDenominator){
        this.denominator=NewDenominator;
    }
    public void ChangeNumerator(int NewNumerator){
        this.numerator=NewNumerator;
    }
    public int GetNumerator(){return this.numerator;}
    public int GetDenominator(){return this.denominator;}


    private void Simplify(){
        int GCD = MyCommonMath.gcd(this.denominator,this.numerator);
        this.ChangeNumerator(this.numerator/GCD);
        this.ChangeDenominator(this.denominator/GCD);
        if(numerator>0 && denominator<0){this.ChangeNumerator((-1)*numerator);this.ChangeDenominator(-1*denominator);}
    }
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator can't be equal to zero");
        }
        this.denominator = denominator;
        this.Simplify();
    }

    public Rational add(Rational other) {
        int NewDenominator = MyCommonMath.lcd(this.denominator,other.GetDenominator());
        int NewNominator = (  NewDenominator/this.denominator ) * this.numerator + ( NewDenominator/other.GetDenominator() ) * other.GetNumerator();
        Rational result = new Rational(NewNominator, NewDenominator);
        result.Simplify();
        return result;
    }

    public Rational subtract(Rational other) {
        int NewDenominator = MyCommonMath.lcd(this.denominator, other.GetDenominator());
        int NewNominator = ( NewDenominator / this.denominator) * this.numerator - (NewDenominator / other.GetDenominator()) * other.GetNumerator();
        Rational result = new Rational(NewNominator, NewDenominator);
        result.Simplify();
        return result;
    }

    public Rational multiply(Rational other) {
        this.Simplify();
        other.Simplify();
        int NewNumerator = this.numerator*other.GetNumerator();
        int NewDenominator = this.denominator*other.GetDenominator();
        var result = new Rational(NewNumerator,NewDenominator);
        result.Simplify();
        return result;
    }

    public Rational divide(Rational other) {
        this.Simplify();
        other.Simplify();
        int NewNumerator = this.numerator*other.GetDenominator();
        int NewDenominator = this.denominator*other.GetNumerator();
        var result = new Rational(NewNumerator,NewDenominator);
        result.Simplify();
        return result;
    }
    public int compareTo(Rational other) {
        Rational Answer = this.subtract(other);
        if (Answer.GetNumerator()*Answer.GetDenominator()<0) {return -1;}
        else if (Answer.GetNumerator()*Answer.GetDenominator()>0) {return 1;}
        else return 0;
    }
    static String toString(Rational InputRational) {
        return Integer.toString(InputRational.numerator) + "/" + Integer.toString(InputRational.denominator);
    }
    static boolean CheckSymbol(String InputSymbol){
        if(SymbolList.contains(InputSymbol)){return true;} else{throw new IllegalArgumentException("'"+InputSymbol+"' is not a valid operator.");}
    }
    static Rational parseRational(String InputString) {
        Rational res ;
        if (InputString.length() ==0) {throw new IllegalArgumentException("Empty input");}
        String[] in = InputString.split("/");
        if (in.length != 2) {throw new IllegalArgumentException("Can't parse "+InputString+" as input.");}
            else{
                try{Integer.parseInt(in[0]);}
                catch(IllegalArgumentException ex){throw new IllegalArgumentException("Incorrect numerator input");}
                try{Integer.parseInt(in[1]);}
                catch(IllegalArgumentException ex){throw new IllegalArgumentException("Incorrect denominator input");}
                try {res = new Rational(Integer.parseInt(in[0]),Integer.parseInt(in[1]));}
                catch (IllegalArgumentException ex) {throw new NumberFormatException(ex.getMessage());}
                return res;
            }
        }

    }

