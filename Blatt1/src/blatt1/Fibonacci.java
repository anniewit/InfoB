package blatt1;

public class Fibonacci{


  int firstNumber = 0;  //f(0)
  int secondNumber = 1; //f(1)

  public int next(){
    int sum = firstNumber + secondNumber;
    firstNumber = secondNumber;
    secondNumber = sum;

    return sum;
  }

}
