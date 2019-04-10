package blatt02;

/**
 * Altertümlicher Börsenticker, der Firma und ihren veränderten Wert auf die Konsole ausgibt.
 * @author Annemarie Witschas, Fabian Westphal
 *
 */
public class Ticker {
	private static Ticker t;
	
	
	/**
	 * Singleton Konstruktor, kann nicht von außen aufgerufen werden
	 */
	private Ticker() {}
	
	/**
	 * Checks whether there is already a Ticker and if not, creates a new Ticker.
	 * @return Ticker
	 */
	public static Ticker getInstance() {
		if(t == null) {
			t = new Ticker();
		}
		return t;
	}
	
	/**
	 * Druckt übergebenen Aktienkurs auf die Konsole aus
	 * @param text Aktienkurs, der ausgegeben werden soll
	 */
	void print(String text) {
		System.out.print("+++" + text);
	}
	

}
