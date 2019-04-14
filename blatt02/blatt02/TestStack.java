public class TestStack{

  public static void main(String[] args) {

    StringStack stackOne = new StringStack();
    //TEST1
    //Ersten Stack befuellen
    stackOne.push("Hallo ");
    stackOne.push("liebe ");
    stackOne.push("Welt ");
    //Aufrufen des Copy-Konstruktors
    StringStack stackTwo = new StringStack(stackOne);
    //Test ob Kopie vollstaendig
    boolean test1 = AssertBoolean.fullCopy(stackOne,stackTwo);
    System.out.println("Test 1(true expected): "+test1);

    //TEST2
    //Ersten Stack befuellen
    stackOne.push("Hallo ");
    stackOne.push("liebe ");
    stackOne.push("Welt ");
    //Aufrufen des Copy-Konstruktors
    stackTwo = new StringStack(stackOne);
    //Manipulieren des *Ausgangstacks*
    stackOne.pop();
    stackOne.push("Stapel 1 Anhang");
    //Test ob Stacks unabhaengig voneinander
    boolean test2 = AssertBoolean.fullCopy(stackOne,stackTwo);
    System.out.println("Test 2(false expected): "+test2);

    //TEST3
    //Ersten Stack befuellen
    stackOne.push("Hallo ");
    stackOne.push("liebe ");
    stackOne.push("Welt ");
    //Aufrufen des Copy-Konstruktors
    stackTwo = new StringStack(stackOne);
    //Manipulieren des *kopierten Stacks*
    stackTwo.pop();
    stackTwo.push("Stapel 2 Anhang");
    //Test ob Stacks unabhaengig voneinander
    boolean test3 = AssertBoolean.fullCopy(stackOne,stackTwo);
    System.out.println("Test 3(false expected): "+test3);

    /*
    //Ausgabe des originalen Strings
    while (!stackOne.empty()) {
      System.out.println(stackOne.pop());
    }
    //Ausgabe der Kopie
    while (!stackTwo.empty()) {
      System.out.println(stackTwo.pop());
    }
    */
    
  }
}
