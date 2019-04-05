package blatt1;
import java.util.Arrays;

public class Fraglich {

   static int a;

   public static void main(String[] args) {
      int a = 3;
      int[] c = {18, 2, 1, 8};

      /*** Stelle 1 
       * a = 3
       * no b
       * c = {18, 2, 1, 8}
       * ***/
      System.out.println("Stelle 1: " + a  + " " + Arrays.toString(c));

      

      initialize();

      /*** Stelle 3 
       * a = 3 (nimmt zuerst die lokale variable)
       * no b
       * c = {18, 2, 1, 8}
       * ***/
      System.out.println("Stelle 3: " + a  + " " + Arrays.toString(c));


      for (int b = -1; b < 1; b += 3) {

         /*** Stelle 4 
          * a = 3, b = -1, c = {18, 2, 1, 8}
          * **/
          System.out.println("Stelle 4: " + a  + " "+ b +" " + Arrays.toString(c));

         a /= 2;
         c[b + 2] -= c[b + 2];
      }

      /*** Stelle 5 
       * a = 3/ 2 = 1 (weil int)
       * no b
       * c = {18, 0, 1, 8}
       * ***/
      System.out.println("Stelle 5: " + a  + "  "+ Arrays.toString(c));

      for (a = 2; a < 3; a++) {

         int b = 2;
         c[a] -= c[b]; // 1 - 1 = 0

         /*** Stelle 6 
          * a = 2
          * b = 2
          * c = {18, 0, 0, 8}***/
          System.out.println("Stelle 6: " + a  + " "+ b +" " + Arrays.toString(c));

      }

      /*** Stelle 7 
       * a = 3 (erhöht in for-schleife)
       * no b
       * c = {18, 0, 0, 8}***/
      System.out.println("Stelle 7: " + a  + " " + Arrays.toString(c));



      int b = method(a + c[a - 3]); // 3+18 =21

      /*** Stelle 9 
       *  a = 3, b = 23, c = {18, 0, 0, 8}***/
          System.out.println("Stelle 9: " + a  + " "+ b +" " + Arrays.toString(c));

      b = 7 + method(++a, c); // method(4,{18,0,0,8}) = 5 + 7 = 12

      /*** Stelle 11 
       * a = 4, b = 12, c ={9,0,0,8} Warum 9 und nicht 18?**/
      System.out.println("Stelle 11: " + a  + " "+ b +" " + Arrays.toString(c));



      a = method(method(method(a), new int[]{b, a, c[0], c[2], c[3], c[1]}));
                        //method(4) = 23
                //method(23, {12, 18, 0, 8, 0}) = 24
          //method(24) = 23

      /*** Stelle 15 
       * a = 23, b = 12, c = {18,0,0,8} ***/
      System.out.println("Stelle 15: " + a  + " "+ b +" " + Arrays.toString(c));

   }

   static void initialize() {

      int b = 0;

      a = 23;

      /*** Stelle 2 
       * a = 23, b = 0, no c
       * ***/
      System.out.println("Stelle 2: " + a  +  " " + b );

   }

   protected static int method(int b) {

      /*** Stelle 8, 12 bzw. 14 
       * 8: a = 23, b = 21, no c
       * 12: a = 23, b = 4, no c
       * 14: a = 23, b = 24, no c
       * ***/
      System.out.println("Stelle 8/12/14: " + a  + " "+ b );


      return a;
   }

   private static int method(int a, int[] c) { // a= 4, a = 23

      a++;
      c[0] /= 2;
      c[0] = c[0] + c[1];
      c = new int[4];
      

      /*** Stelle 10 
       * a = 5, no b, c ={0,0,0,0}
       * bzw. 13 
       * a = 24, no b, c = {0,0,0,0} ***/
      System.out.println("Stelle 10/13: " + a  + "  " + Arrays.toString(c));


      return a;
   }

}
