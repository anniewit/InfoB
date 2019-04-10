package blatt02;

public class TestStringStack {

	public static void main(String[] args) {
		
		//Original anlegen
		StringStack original = new StringStack();
		
		// Original befüllen
		for(int i = 0; i < 5; i++) {
			original.push(Integer.toString(i));
		}
		
		//kopieren
		StringStack copy = new StringStack(original);
		
		//Copy ändern
		copy.pop();
		
		//vergleichen
		
		
		

	}

}
