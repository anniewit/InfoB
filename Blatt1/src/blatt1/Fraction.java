package blatt1;
/**
 * 
 */
public class Fraction{

    private int numerator; //Z�hler
    private int denominator; //Nenner

    //Konstruktor
    public Fraction(int num, int denom){
    	
    	if(denom == 0) {
    		System.out.println("Nenner darf nicht 0 sein.");
    		System.out.println("Programm wird beendet.");
    		System.exit(-1);
    	}

        //k�rzen, indem gr��ter gemeinsamer Teiler gefunden wird
        int ggt = getGgt(num,denom);

        //durch ggt dividieren, wenn ggt nicht gleich numerator
        if(ggt != num){
            num /= ggt;
            denom /= ggt; 
        }
        
        this.numerator = num;
        this.denominator = denom;
    }

    //Constructor Chaining
    public Fraction(int num){
        this(num, 1);
    }

    /**
     * berechnet Größten Gemeinsamen Teiler nach dem Euklidischen Alorithmus
     * @param a Zähler
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
      * Dividiert Bruch durch einen anderen, indem mit dem Reziproken des �bergebenen Bruchs multipliziert wird
      * @param divisor Bruch, durch den geteilt werden soll, wird ins reziproke umgewandelt
      * @return
      */
    Fraction divide(Fraction divisor){
    	//tauschen von Z�hler und Nenner
        int rezDenom = divisor.getNumerator();
        int rezNum = divisor.getDenominator();
        Fraction reziproke = new Fraction(rezNum, rezDenom);
        Fraction quotient = this.multiply(reziproke);
        return quotient;

    }
 
    int getNumerator(){
        return this.numerator;
    }
    int getDenominator(){
        return this.denominator;
    }
}