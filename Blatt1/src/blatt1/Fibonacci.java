package blatt1;

/**
 * Implementiert die Fibonacci Reihe, welche immer die beiden vorherigen Werte addiert, beginnend mit 0 und 1.
 * 
 * @author Fabian Westphal, Annemarie Witschas
 *
 */
public class Fibonacci{


  int firstNumber = 0;  //f(0)
  int secondNumber = 1; //f(1)

  /**
   * 
   * @return Summe der beiden letzten Zahlen als aktuelles Folgenglied
   */
  public int next(){
    int sum = firstNumber + secondNumber;
    firstNumber = secondNumber;
    secondNumber = sum;

    return sum;
  }

}
