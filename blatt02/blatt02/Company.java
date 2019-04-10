package blatt02;

/**
 * Creates Company Objects that can be used for the Ticker Class.
 * @author Annemarie Witschas, Fabian Westphal
 *
 */
public class Company {
	private String name;
	
	//Konstruktor
	public Company(String compName) {
		this.name = compName;
	}
	
	/**
	 * changes stock price of given Company and prints it to the console
	 * @param d
	 */
	void changeStockPrice(double d) {
		String ausgabe = this.name + " " + d;
		
		Ticker t = Ticker.getInstance();
		
		t.print(ausgabe);
	}
}
