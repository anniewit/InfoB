package blatt02;

/**
 * @author Annemarie Witschas, Fabian Westphal
 *
 */
public class TestTicker {
	
	public static void main(String args[]) {
		
		//TODO Welche Sonderfälle sollten getestet werden?
		
		// Companies erzeugen
		Company firma = new Company("Schwäbischer Immobilienmogul");
		
		firma.changeStockPrice(1005.4);
		
		//TODO nicht mehr gebrauchte Objekte auf Null setzen
		
		// Garbage Collector aufrufen
		System.gc();
		
	}
}

 
