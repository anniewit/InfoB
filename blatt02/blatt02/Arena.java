package blatt02;

import java.lang.Math;

public class Arena {

	
	int getArea(double x, double y) {
		
		double radius = Math.sqrt( Math.pow(x,2) + Math.pow(y, 2));
	//	double angle = Math.atan(y / x);
		double radians = Math.atan2(y, x);
		// Radians in degree umwandeln
		double angle = radians * 180 / Math.PI;
		
		
		//When outside of arena
		if(radius > 1.5) {
			return -1;
		}
		System.out.println("Angle: " +  angle);
		System.out.println(angle/30);
		//get the area
		int area = (int) angle / 30 ;
		
		return area;
				
	}
}
