public class Rational {
    int numerator = 0;
    int denominator = 0;

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("Incorrect denominator input");
        }
        this.denominator = denominator;
    }

    public Rational Add(Rational other) {
        int NewDenominator = gcd(this.denominator, other.denominator);
        int NewNominator = (NewDenominator / this.denominator) * this.numerator + (NewDenominator / other.denominator) * other.numerator;
        Rational result = new Rational(NewNominator, NewDenominator);
        return result;
    }

    public Rational subtract(Rational other) {
        int NewDenominator = gcd(this.denominator, other.denominator);
        int NewNominator = (NewDenominator / this.denominator) * this.numerator - (NewDenominator / other.denominator) * other.numerator;
        Rational result = new Rational(NewNominator, NewDenominator);
        return result;
    }

    public Rational multiply(Rational other) {
        int SemiNominator = this.numerator / gcd(this.numerator, this.denominator);
        this.denominator = this.denominator / gcd(this.numerator, this.denominator);
        SemiNominator = SemiNominator / gcd(SemiNominator, other.denominator);
        other.denominator = other.denominator / gcd(SemiNominator, other.denominator);
        int SecondSemiNominator = other.numerator / gcd(other.numerator, this.denominator);
        this.denominator = this.denominator / gcd(other.numerator, this.denominator);
        SecondSemiNominator = SecondSemiNominator / gcd(SecondSemiNominator, other.denominator);
        other.denominator = other.denominator / gcd(SecondSemiNominator, other.denominator);
        Rational result = new Rational(SemiNominator * SecondSemiNominator, other.denominator * this.denominator);
        return result;
    }

    public Rational divide(Rational other) {
        int c = other.denominator;
        other.denominator = other.numerator;
        other.numerator = c;
        int SemiNominator = this.numerator / gcd(this.numerator, this.denominator);
        this.denominator = this.denominator / gcd(this.numerator, this.denominator);
        SemiNominator = SemiNominator / gcd(SemiNominator, other.denominator);
        other.denominator = other.denominator / gcd(SemiNominator, other.denominator);
        int SecondSemiNominator = other.numerator / gcd(other.numerator, this.denominator);
        this.denominator = this.denominator / gcd(other.numerator, this.denominator);
        SecondSemiNominator = SecondSemiNominator / gcd(SecondSemiNominator, other.denominator);
        other.denominator = other.denominator / gcd(SecondSemiNominator, other.denominator);
        Rational result = new Rational(SemiNominator * SecondSemiNominator, other.denominator * this.denominator);
        return result;
    }

    public int compareTo(Rational other) {
        Rational ans = this.subtract(other);
        if (ans.numerator < 0 || ans.denominator < 0) {
            return -1;
        }
        if (ans.numerator > 0 && ans.denominator > 0) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        if (this.denominator == 0) {
            throw new IllegalArgumentException("Invalid rational");
        }
        return Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);
    }

    static Rational parseRational(String s) {
        Rational res ;
        if (s.length() < 3) {
            throw new IllegalArgumentException("Empty or partial input");
        }
        String[] in = s.split("/");
        if (in.length > 2) {
            throw new IllegalArgumentException("Too many arguments");
        } else {
            if (in.length == 1) {
                throw new IllegalArgumentException("Missing denominator/numerator");
            } else {
                try {
                    res = new Rational(Integer.parseInt(in[0]),Integer.parseInt(in[1]));
                } catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException("Incorrect numerator/denominator");
                }
            }
        }
        return res;
    }
}

