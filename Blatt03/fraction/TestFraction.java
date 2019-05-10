//package fraction;

/**
 * Test the functionality of the Class Fraction. As this class is just a
 * test class, its methods do not require JavaDoc.
 * 
 * Testing proper error handling for denominator == 0 would be useful, but for
 * that we require Exceptions which we only cover in chapter 4 of the lecture.
 * Thus, we forego testing this error handling.
 *
 * @author Lars Huning
 */
public class TestFraction {
   private int nrErrors;
    
   public static void main(String[] args) {
       
       System.out.println("Start testing...");
       TestFraction test = new TestFraction();
       test.testToString();
       test.testGgt();
       test.testMultiply();
       test.testDivide();
       
       System.out.println("Found " + test.getNrErrors() + " errors");
       System.out.println("... testing finished");
   }
     
   public void testToString() {
       String errMsg = "toString";
       Fraction a = new Fraction(1,2);
       assertEquals("1/2",a, errMsg);
       
       
       //Testing same string representation of Fraction, regardless of whether
       //the first or second parameter during construction was negative
       Fraction b = new Fraction(-1, 2);
       assertEquals("-1/2", b, errMsg);
       
       Fraction c = new Fraction(1, -2);
       assertEquals("-1/2", c, errMsg);
       
       //Testing that positive Fraction is not stored as two negative numbers
       Fraction d = new Fraction(-1,-2);
       assertEquals("1/2", d, errMsg);

   }
   
   public void testGgt() {
       String errMsg = "Errr in ggt() method";
       assertBool(Fraction.gcd(8, 2) == 2, errMsg);
       assertBool(Fraction.gcd(5, 2) == 1, errMsg);
       assertBool(Fraction.gcd(125, 50) == 25, errMsg);
   }
   
   public void testMultiply() {
       String errMsg = "testMultiply(Fraction)";
       Fraction a = new Fraction(1,2);
       Fraction b = new Fraction (-3,4);
       assertEquals("-3/8", a.multiply(b), errMsg);
       
       errMsg = "testMultiply(int)";
       assertEquals("5/1", a.multiply(10), errMsg);
       
       errMsg = "testMultiply(Fraction...)";
       Fraction c = new Fraction(2,3);
       assertEquals("-1/4", a.multiply(b,c), errMsg);

       errMsg = "testMultiply(two floats)";
       assertBool(-817.0 == Calculator.calculate((float)-19,(float)43,"^*"), errMsg);
       
       //testing that varargs parameter may also be empty
       assertEquals("1/2", a.multiply(), errMsg);

       
   }
   
   public void testDivide() {
       String errMsg = "testDivide";
       Fraction a = new Fraction(1,2);
       Fraction b = new Fraction(3,4);
       Fraction c = new Fraction(-3,4);

       
       assertEquals("2/3", a.divide(b), errMsg);
       assertEquals("3/2", b.divide(a), errMsg);
       assertEquals("-2/3", a.divide(c), errMsg);
       assertBool(-19.0 == Calculator.calculate((float)-817, (float)43,"/"),"testDivide(two floats)" );

   }
   
   /**
    * Convenience method for testing boolean statements
    * @param statement The statement to be tested
    * @param errorMsg The error msg to be displayed in case the test failed
    */
   private void assertBool(boolean statement, String errorMsg) {
       if(!statement) {
           this.nrErrors++;
           System.out.println(errorMsg);
       }
   }
   
   
   /**
    * Convenience method for checking the value of a Fraction. Depends on the
    * toString() method in Fraction.
    * @param expected The value of the Fraction that we expect
    * @param actual The Fraction instance we want to test
    * @param methodName The name of the test-method which calls this method
    */
   private void assertEquals(String expected, Fraction actual, 
           String methodName) {
      assertEquals(expected, actual.toString(), methodName);
   }
   
   /**
    * Convenience method for testing two strings
    * @param expected The string that we expect
    * @param actual The string that we want to test
    * @param methodName Name of the test-method which calls this method.
    */
   private void assertEquals(String expected, String actual, 
           String methodName) {
       
      if (!expected.equals(actual)) {
          this.nrErrors++;
          System.out.println("FAIL in " + methodName 
                 + "() [expectded: " + expected + " but was "+ actual + "]");
      }
   }
   
   public int getNrErrors() {
       return this.nrErrors;
   }
}
