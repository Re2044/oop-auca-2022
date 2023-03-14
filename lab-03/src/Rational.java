import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rational {
    private static List<String> SymbolList = List.of("+","-","/","*",">=","<=","!=","=",">","<");
    private int numerator = 0;
    private int denominator = 0;
    static String Operation(Rational first, Rational second, String InputSymbol){
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
    public int gcd(int a, int  b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public int lcd(int a,int b){
        return (a*b)/gcd(a,b);
    }
    public void Simplify(){
        int GCD = gcd(this.denominator,this.numerator);
        this.ChangeNumerator(this.numerator/GCD);
        this.ChangeDenominator(this.denominator/GCD);
    }
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator can't be equal to zero");
        }
        this.denominator = denominator;
    }

    public Rational add(Rational other) {
        int NewDenominator = lcd(this.denominator,other.GetDenominator());
        int NewNominator = (  NewDenominator/this.denominator ) * this.numerator + ( NewDenominator/other.GetDenominator() ) * other.GetNumerator();
        Rational result = new Rational(NewNominator, NewDenominator);
        return result;
    }

    public Rational subtract(Rational other) {
        int NewDenominator = lcd(this.denominator, other.GetDenominator());
        int NewNominator = ( NewDenominator / this.denominator) * this.numerator - (NewDenominator / other.GetDenominator()) * other.GetNumerator();
        Rational result = new Rational(NewNominator, NewDenominator);
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
    public boolean IsLowerOrEqual(Rational other) {if (IsLower(other)==true || Equals(other)==true) {return true;} else return false;}
    public boolean IsBiggerOrEqual(Rational other) {if (IsBigger(other)==true || Equals(other)==true) {return true;} else return false;}
    public boolean Equals(Rational other){
        Rational SubtractResult = this.subtract(other);
        if (SubtractResult.GetNumerator() == 0) {return false;} else return true;
    }
    public boolean IsBigger(Rational other) {
        Rational SubtractResult = this.subtract(other);
        if (SubtractResult.GetNumerator() * SubtractResult.GetDenominator() < 0) {return false;} else return true;
    }
    public boolean IsLower(Rational other) {
        Rational SubtractResult = this.subtract(other);
        if (SubtractResult.GetNumerator() * SubtractResult.GetDenominator() < 0) {return true;} else return false;
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

