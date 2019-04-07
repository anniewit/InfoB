package blatt1;

public class TestFraction{
  public static void main(String[] args) {
    //Instanzierung
    TestFraction test = new TestFraction();
    //sample Fractions
    Fraction fractionOne = new Fraction(7,8);
    Fraction fractionTwo = new Fraction(3,5);
    Fraction fractionThree = new Fraction(11,15);
    Fraction fractionFour = new Fraction(2,3);

    //Testing
    test.testMultiply(fractionTwo,3);
    test.testMultiply(fractionOne, fractionTwo);
    test.testDivide(fractionOne, fractionThree);
    test.testMultiply(fractionOne, fractionTwo, fractionThree, fractionFour);
    //TODO: automatische Ausgabe ob Test erfolgreich
  }
  /**
  Die Methode testet die Multiplikation eines Bruchs mit einer Zahl
  */
  public void testMultiply(Fraction fraction, int factor){
    Fraction result = fraction.multiply(factor);
    String answer = result.toString();
    System.out.println(answer);
  }
  /**
  Die Methode testet die Multiplikation eines Bruchs mit einem anderen Bruch
  */
  public void testMultiply(Fraction fraction, Fraction factor){
    Fraction result = fraction.multiply(factor);
    String answer = result.toString();
    System.out.println(answer);
  }
  /**
  Die Methode testet die Division eines Bruchs durch einen anderen Bruch
  */
  public void testDivide(Fraction fraction, Fraction divisor){
    Fraction result = fraction.divide(divisor);
    String answer = result.toString();
    System.out.println(answer);
  }
  /**
  Die Methode testet die Multiplikation eines Bruchs mit einer beliebigen Anzahl an anderen Brüchen
  */
  public void testMultiply(Fraction fraction, Fraction...factors){
    Fraction result = fraction.multiply(factors);
    String answer = result.toString();
    System.out.println(answer);
  }
}
