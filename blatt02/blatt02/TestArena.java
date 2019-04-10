package blatt02;

public class TestArena {
	
	public static void main(String [] args) {
		
		Arena arena = new Arena();
		
		
		double x = 0.2;
		double y = 0.8;
		
		
		int area = arena.getArea(x,y);
		System.out.println(area);
	}

}
