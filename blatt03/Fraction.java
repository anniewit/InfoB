import java.util.regex.Pattern;
/**
 * Every instance of <code>Fraction</code> represents a fraction with numerator
 * and denominator.
 *
 * @author Lars Huning
 */
public class Fraction {

   /**
    * Creates greatest common divisor for a and b.
    *
    * @param a
    * @param b
    * @return the greatest common divisor for a and b.
    */
   public static int gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
   }

   /**
    * Numerator of the Fraction
    */
   private final int numerator;

   /**
    * Denominator of the Fraction
    */
   private final int denominator;

   /**
    * Creates a Fraction object with numerator and denominator 1, reduces the
    * fraction with creation.
    *
    * @param numerator
    */
   public Fraction(int numerator) {
      this(numerator, 1);
   }

   /**
    * Creates a Fraction object with numerator and denominator. Reduces the
    * fraction in the constructor.
    * Denominator == 0 is not allowed. In such a case, the program terminates
    * with an error message
    *
    * @param numerator   the numerator
    * @param denominator the denominator, must not be 0.
    */
   public Fraction(int numerator, int denominator) {
      if (denominator == 0) {
          System.out.println("denominator == 0 is not possible");
          System.out.println("Terminating program");
          System.exit(-1);
      }

      /*
       * creates greatest common divisior.
       */
      int gcd = Fraction.gcd(numerator, denominator);

      /*
       * check sign, make denominator positive --> the sign of the fraction
       * is always stored only in the numerator.
       */
      if (denominator / gcd < 0) {
         gcd *= -1;
      }

      this.numerator = numerator / gcd;

      this.denominator = denominator / gcd;
   }

   /**
    * Divides this Fraction with another Fraction. Terminates the program in
    * case numerator of another is zero (via constructor of the newly created
    * Fraction).
    *
    * @param another Fraction to divide this Fraction by
    * @return Quotient as a new Fraction
    *
    */
   public Fraction divide(Fraction another) {
      return new Fraction(this.numerator * another.denominator,
            this.denominator * another.numerator);
   }

   /**
    * Note: "Default" getters and setters do not always require JavaDoc,
    * as their purpose is obvious
    */
   public int getDenominator() {
      return this.denominator;
   }

   public int getNumerator() {
      return this.numerator;
   }

   /**
    * Multiplies this Fraction with another Fraction
    *
    * @param factor Fraction to multiply this Fraction with
    * @return The product as a new Fraction
    */
   public Fraction multiply(Fraction factor) {
      return new Fraction(this.numerator * factor.numerator, this.denominator
            * factor.denominator);
   }

   /**
    * Multiplies this Fraction with all other Fraction instances given by
    * the parameter factors
    *
    * @param factors Fraction instances to multiply this Fraction with
    * @return The product as a new Fraction
    */
   public Fraction multiply(Fraction... factors) {
      Fraction result = this;

      //variable parameters may be treated like an array inside the method
      for (int i = 0; i < factors.length; i++) {
         result = result.multiply(factors[i]);
      }
      return result;
   }

   /**
    * Multiplies this Fraction with int n.
    *
    * @param n factor to multiply with
    * @return The product as a new Fraction
    */
   public Fraction multiply(int n) {
      return new Fraction(this.numerator * n, this.denominator);
   }
   /**
    * Adds a Fraction to this Fraction.
    *
    * @param addend Fraction to add
    * @return The sum as a new Fraction
    */
   public Fraction add(Fraction addend){
      int extendedNumerator = this.numerator * addend.denominator;
      int extendedDenominator = this.denominator * addend.denominator;
      int extendedNumeratorTwo = addend.numerator * this.denominator;
      int extendedDenominatorTwo = addend.denominator * this.denominator;
      return new Fraction(extendedNumerator + extendedNumeratorTwo, extendedDenominator);
   }
   /**
    * Subtracts a Fraction from this Fraction.
    *
    * @param addend Fraction to subtract
    * @return The difference as a new Fraction
    */
   public Fraction subtract(Fraction subtrahend){
      int extendedNumerator = this.numerator * subtrahend.denominator;
      int extendedDenominator = this.denominator * subtrahend.denominator;
      int extendedNumeratorTwo = subtrahend.numerator * this.denominator;
      int extendedDenominatorTwo = subtrahend.denominator * this.denominator;
      return new Fraction(extendedNumerator - extendedNumeratorTwo, extendedDenominator);
   }
   /**
    * Parses a Fraction from input.
    *
    * @param input the input String
    * @return the Fraction in the String
    */
   public static Fraction parseFraction(String input){
     boolean b = Pattern.matches("-?\\d+/-?[1-9]+", input);
     int numerator = 0;
     int denominator = 0;
     if (b) {
       String[] parts = input.split("/");
       numerator = Integer.parseInt(parts[0]);
       denominator = Integer.parseInt(parts[1]);
     }else {
       System.out.println("invalid expression");
       System.out.println("Terminating program");
       System.exit(-1);
     }
     return new Fraction(numerator, denominator);
   }
   /**
    * Returns a string representation of this Fraction such as
    * numerator/denominator. As the constructor has already made sure that
    * a negative Fraction is represented by a negative numerator and a positive
    * denominator, negative fractions are always displayed with the minus sign
    * at the numerator (Advantage: consistent notation, for example if anyone
    * decides to parse the results of this method with a string parser)
    *
    * @return This Fraction as a String
    */
   public String toString() {
      return numerator + "/" + denominator;
   }
}
