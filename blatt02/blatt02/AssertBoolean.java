public class AssertBoolean{

  public static boolean fullCopy(StringStack stackOne, StringStack stackTwo){
    while (!stackOne.empty()) {
      if (stackOne.pop()!=stackTwo.pop()) {
        return false;
      }
    }
    return true;
  }
}
