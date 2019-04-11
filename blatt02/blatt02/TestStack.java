public class TestStack{

  public static void main(String[] args) {

    StringStack stackOne = new StringStack();
    stackOne.push("Hallo ");
    stackOne.push("liebe ");
    stackOne.push("Welt ");

    System.out.println("Anfang");

    StringStack stackTwo = new StringStack(stackOne);

    while (!stackOne.empty()) {
      System.out.println(stackOne.pop());
    }
    while (!stackTwo.empty()) {
      System.out.println(stackTwo.pop());
    }
    System.out.println("Ende");
  }
}
