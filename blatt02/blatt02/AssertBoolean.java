public class AssertBoolean{

  public static boolean fullCopy(StringStack stackOne, StringStack stackTwo){
    while (!stackOne.empty()) {
      if (stackOne.pop()!=stackTwo.pop()) {
        return false;
      }
    }
    return true;
  }
  public static boolean correctArea(int expectedArea, int x, int y){
    Arena arena = new Arena();
    if (expectedArea != arena.getArea(x,y)) {
      return false;
    }
    return true;
  }
}
