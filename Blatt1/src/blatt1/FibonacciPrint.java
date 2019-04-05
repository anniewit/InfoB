package blatt1;
public class FibonacciPrint{

  public static void main(String[] args) {

    //Eingabe einlesen
    String s = args[0];
    int number = Integer.parseInt(s);

    if (number <= 0) {
      System.out.println("Bitte nur positive Werte eingeben.");
      System.exit(-1);
    }

    Fibonacci fibonacci = new Fibonacci();


    System.out.println("| n |  f(n)  |");
    System.out.println("+---+--------+");
    System.out.println("|  0|       0|");
    System.out.println("|  1|       1|");

    //Gibt die Fibonacci-Zahl ab f(2) aus
    for (int i=2;i<=number ;i++ ) {
      System.out.printf("|%3d|%8d|\n",i,fibonacci.next());
    }


  }
}
