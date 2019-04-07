package blatt1;
/**
 * Klasse, die Brüche aus übergebenen ints erstellt und folgende Rechenarten durchführt:
 * Multiklipation mit Konstante, anderem Bruch und mehrern Brüchen, Division durch einen Bruch
 * @author Fabian Westphal, Annemarie Witschas
 */
public class Fraction{

    private int numerator; //Zähler
    private int denominator; //Nenner

    /**
     * Konstruiert Fraction-Objekt aus übergebenen ints 
     * kürzt automatisch
     * @param num
     * @param denom
     */
    public Fraction(int num, int denom){
    	
    	if(denom == 0) {
    		System.out.println("Nenner darf nicht 0 sein.");
    		System.out.println("Programm wird beendet.");
    		System.exit(-1);
    	}

        //kürzen, indem größter gemeinsamer Teiler gefunden wird
        int ggt = getGgt(num,denom);
        
        // durch größten gemeinsamen Teiler teilen
        num /= ggt;
        denom /= ggt; 
               
        this.numerator = num;
        this.denominator = denom;
    }

    /**
     * Constructor Chaining: Ist kein Nenner angegeben, 1 als Nenner setzen
     * @param num Zähler
     */
    public Fraction(int num){
        this(num, 1);
    }

    /**
     * berechnet Größten Gemeinsamen Teiler nach dem Euklidischen Alorithmus
     * @param a Zahler
     * @param b Nenner
     * @return größten gemeinsamen Teiler
     */
    public int getGgt(int a, int b){
        int rest;
        while (b != 0){
            rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }
    

    Fraction multiply(int factor){
        int num = this.numerator * factor;
        int denom = this.denominator;
        Fraction product = new Fraction(num, denom);
        return product;

    }

     Fraction multiply(Fraction factor){
        int num = this.numerator * factor.getNumerator();
        int denom = this.denominator * factor.getDenominator();
        Fraction product = new Fraction(num, denom);
        return product;

    }
     /**
      * Dividiert Bruch durch einen anderen, indem mit dem Reziproken des übergebenen Bruchs multipliziert wird
      * @param divisor Bruch, durch den geteilt werden soll, wird ins reziproke umgewandelt
      * @return
      */
    Fraction divide(Fraction divisor){
    	//tauschen von Zähler und Nenner
        int rezDenom = divisor.getNumerator();
        int rezNum = divisor.getDenominator();
        Fraction reziproke = new Fraction(rezNum, rezDenom);
        Fraction quotient = this.multiply(reziproke);
        return quotient;

    }
    Fraction multiply(Fraction ... factor){
    	int num = 1;
    	int denom = 1;
    	for(int i = 0; i < factor.length; i++) {
    		num *= this.numerator * factor[i].getNumerator();
    		denom *= this.denominator * factor[i].getDenominator();
    	}
        
        Fraction product = new Fraction(num, denom);
        return product;

    }
 
    int getNumerator(){
        return this.numerator;
    }
    int getDenominator(){
        return this.denominator;
    }
}