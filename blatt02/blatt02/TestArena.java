public class TestArena{

  public static void main(String[] args) {
    Arena arena = new Arena();

    //TEST1
    //Testing der Fälle in denen sich der Tribut außerhalb der Arena befindet
    boolean test1 = AssertBoolean.correctArea(-1,0,-2);
    System.out.println("Test (ausserhalb, true expected): "+test1);
    boolean test2 = AssertBoolean.correctArea(-1,2,0);
    System.out.println("Test (ausserhalb, true expected): "+ test2);

    //TEST2
    //Testing der vier Quadranten
    boolean test3 = AssertBoolean.correctArea(2,1,1);
    System.out.println("Test (Quadrant 1, true expected): "+ test3);
    boolean test4 = AssertBoolean.correctArea(5,1,-1);
    System.out.println("Test (Quadrant 2, true expected): "+ test4);
    boolean test5 = AssertBoolean.correctArea(8,-1,-1);
    System.out.println("Test (Quadrant 3, true expected): "+ test5);
    boolean test6 = AssertBoolean.correctArea(11,-1,1);
    System.out.println("Test (Quadrant 4, true expected): "+ test6);

    //TEST3
    //Testing der Grenzfälle mit x=0 oder y=0
    boolean test7 = AssertBoolean.correctArea(1,0,0);
    System.out.println("Test ((0,0), true expected): "+ test7);
    boolean test8 = AssertBoolean.correctArea(7,0,-1);
    System.out.println("Test ((0,-1), true expected): "+ test8);
    boolean test9 = AssertBoolean.correctArea(10,-1,0);
    System.out.println("Test ((-1,0), true expected): "+ test9);
    boolean test10 = AssertBoolean.correctArea(1,0,0);
    System.out.println("Test ((0,0), true expected): "+ test10);
    boolean test11 = AssertBoolean.correctArea(1,0,1);
    System.out.println("Test ((0,1), true expected): "+ test11);
    boolean test12 = AssertBoolean.correctArea(4,1,0);
    System.out.println("Test ((1,0), true expected): "+ test12);
  }
}
