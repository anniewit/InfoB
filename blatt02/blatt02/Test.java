package blatt02;

public class Test {
    private int anzahlFehler;
    
    /**
     * main Methode zum durchfuehren der Tests
     * @param args Nicht beruecksichtigt
     */
    public static void main(String[] args) {
        System.out.println("Starte Tests");
        Test test = new Test();
        test.testAll();
        
        System.out.println(test.getAnzahlFehler() + " Fehler in den Tests");
        System.out.println("Tests abgeschlossen");
    }
    
    
    /**
    * Methode zum buendeln aller Testfaelle. Haelt die main() uebersichtlicher
    */
   private void testAll() {
	   //TODO 
   }

    /**
     * Konstruktor, geht erstmal davon aus, dass alle Tests stimmen werden. 
     * Nur wenn ein Test fehlschlaegt, wird der Wert erhöht
     */
    public Test() {
        this.anzahlFehler = 0;
    }
    
    /**
     * Testet einen booleschen Ausdruck und gibt eine Fehlermeldung aus, 
     * falls dieser nicht gilt. Erhoeht zusaetzlich den Counter fuer die Anzahl
     * der festgestellten Fehler.
    * 
     * @param statement Der Ausdruck der ueberprueft werden soll
     * @param errorMsg Die Fehlermeldung
     */
    private void assertBool(boolean statement, String errorMsg) {
        if(!statement) {
            this.anzahlFehler++;
            System.out.println(errorMsg);
        }
    }
    
    
    /**
     * 
     * @return Gibt die Anzahl der Fehler die bei den Tests festgestellten 
     * wurden zurueck
     */
    public int getAnzahlFehler() {
        return this.anzahlFehler;
    }
	
}
