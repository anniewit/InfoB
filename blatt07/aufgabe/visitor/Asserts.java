package visitor;

public class Asserts {

	private int anzahlFehler;

	/**
     * Konstruktor, geht erstmal davon aus, dass alle Tests stimmen werden.
     * Nur wenn ein Test fehlschlaegt, wird der Wert erhöht
     */
    public Asserts() {
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
    public void assertBool(boolean statement, String errMsg) {
        if(!statement) {
            this.anzahlFehler++;
            System.out.println(errMsg);
        }
    }

    /**
     * Asserts that two objects are equal. If they are not
     * an AssertionFailedError is thrown with the given message.
     */
    public void assertEquals(Object expected, Object actual, String errMsg) {
        if (expected == null && actual == null) {
            return;
        }
        if (expected != null && expected.equals(actual)) {
            return;
        }
        if (!expected.equals(actual)){
            this.anzahlFehler++;
            System.out.println(errMsg);
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

    public void finish(){
        System.out.println("Test beendet. \n " + anzahlFehler + " Fehler aufgetreten.");
    }

    public void start(){
        System.out.println("starte Test...");
    }

}
