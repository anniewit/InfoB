//package fraction;

import java.io.IOException;
import java.util.regex.Pattern;


//package blatt03;
/**
 * Bruchrechner, der auf der commandline ausgeführt wird
 * Kann Brüche addieren, subtrahieren, multiplizieren und dividieren
 * Eingabe durch input string im Format: 1/3 + 1/8
 * Multiplikation durch escape character ^*
 */
public class Calculator {

	public static void main(String[] args) {
		// Eingabeformat prüfen
		if(args.length != 3) {
			System.err.println("Keine korrekte Rechnung eingegeben");
			System.err.println("Bitte Rechnung im Format 1/2 + -1/2 eingeben.");
			System.exit(-1);

		}
		
		//String[] args aufteilen		
		String a = args[0];
		String b = args[2];
		String operator = args[1];

		//Brüche auf richtiges Format testen, erstellen, auf Bruch bzw Float rechnen
		if(matchesFraction(a) && matchesFraction(b)){
			Fraction one = Fraction.parseFraction(a);
			Fraction two = Fraction.parseFraction(b);
			System.out.println( calculate(one, two, operator).toString());

		}else if(matchesFloatInt(a) && matchesFloatInt(b)){
			Float one = Float.parseFloat(a);
			Float two = Float.parseFloat(b);
			System.out.println(calculate(one, two, operator));
		}
				
	}
	/**
	 * @param a Fraction 
	 * @param b Fraction
	 * @param operator String [+ - * /] that a and b should be calculated by
	 * @return resulting Fraction
	 */
	public static Fraction calculate(Fraction a, Fraction b, String operator){
		switch(operator) {
			case "+": 	return a.add(b);
			case "-": return a.subtract(b);
			case "^*": return a.multiply(b);
			case "/": return a.divide(b);
			default: 
				System.err.println("Kein korrektes Rechenzeichen eingegeben");
				System.err.println("Bitte Rechnung im Format 1/2 + -1/2 eingeben. Mögliche Rechenzeichen: + * - /");
				System.exit(-1);
				return(a); //only to escape error
		}
	}
	/**
	 * @param a float
	 * @param b float
	 * @param operator String [+ - * /] that a and b should be calculated by
	 * @return resulting float
	 */
	public static float calculate(Float a, Float b, String operator){
		switch(operator) {
			case "+": return (a+b);
			case "-": return (a-b);	
			case "^*": return (a*b);
			case "/": return (a/b);
			default: 
				System.err.println("Kein korrektes Rechenzeichen eingegeben");
				System.err.println("Bitte Rechnung im Format 1/2 + -1/2 eingeben. Mögliche Rechenzeichen: + * - /");
				System.exit(-1);
				return(-1);
		}
	}

	/**
	 * @param s input string from console
	 * @return boolean whether string matches Fraction
	 */
	public static boolean matchesFraction(String s){
		return Pattern.matches("-?\\d+/-?[1-9]\\d*", s);
	}
	/**
	 * @param s input string from console
	 * @return boolean whether string matches Float or Int
	 */
	public static boolean matchesFloatInt(String s){
		return Pattern.matches("-?\\d+[\\.\\d]*", s);
	}

}
