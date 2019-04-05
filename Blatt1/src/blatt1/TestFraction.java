package blatt1;

public class TestFraction {
	
    private int anzahlFehler;
    
    
	/**
     * main Methode zum durchfuehren der Tests
     * @param args Nicht beruecksichtigt
     */
    public static void main(String[] args) {
        System.out.println("Starte Tests");
        TestFraction test = new TestFraction();
        test.testAll();
        
        System.out.println(test.getAnzahlFehler() + " Fehler in den Tests");
        System.out.println("Tests abgeschlossen");
    }
	

}
