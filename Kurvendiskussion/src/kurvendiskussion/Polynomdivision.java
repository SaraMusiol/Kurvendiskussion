package kurvendiskussion;

import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author frank
 * Erlaubnis wurde über GitHub erteilt.
 */


public class Polynomdivision {
		
		
	
	  
	  private static final int grad = 3;	//float zu double
	  private static double[] divident = new double[grad + 1];
	  private static double[] divisor = new double[grad + 1];
	  private static double[] quotient = new double[grad + 1];
	  private static double[] rest = new double[grad + 1];

	  /**
	   * @param args the command line arguments
	   */
	  public static void main(String[] args) {
	    eingabe(divident);
	    eingabe(divisor);
	    division(divident,divisor);
	    ausgabe(quotient);
	    ausgabe(rest);
	  }
	  
	  public static void eingabe(double[] polynom) {
	    System.out.println("Polynom eingeben bis zum Grad:"+grad);
	    for (int i = 0; i <= grad; i++) {
	      System.out.println("Koeffizient für "+i+"-te Potenz:");
	      Scanner sc = new Scanner(System.in);
	      polynom[i] = sc.nextDouble();
	    }
	    System.out.println("\n\n");
	  }
	  
	  public static void ausgabe(double[] polynom) {
	    for (int i = grad; i >= 0; i--) {
	      if (polynom[i] != 0) System.out.format("%+5.3f x^%d ",polynom[i],i);
	    }
	    System.out.println("\n");
	  }
	  
	  public static void division(double[] a, double[] b) {
	    // Koeffizienten und Grad für divisor ermitteln
	    double koeff = 1;
	    int gradDivisor = 0;
	    int i = grad;
	    while (i>=0) {
	      if (b[i] != 0) {
	        gradDivisor = i;
	        koeff = b[i];
	        break;
	      }
	      i--;
	    }
	    /*
	     * für alle Koeffizienten
	     *  1. Faktor ermitteln
	     *  2. ausmultiplizieren
	     *  3. subtrahieren
	     */
	    double faktor;
	    rest = Arrays.copyOf(a, a.length);
	    
	    for (int j = grad; j >= gradDivisor; j--) {
	      faktor = rest[j] / koeff;
	      quotient[j - gradDivisor] = faktor;
	      
	      if (faktor != 0.0) {
	        // ausmultiplizieren
	        double[] zwischenErgebnis = new double[grad + 1];
	        for (int k = 0; k <= gradDivisor; k++) {
	          zwischenErgebnis[k+ j - gradDivisor] = faktor * b[k];          
	        }
	        // subtrahieren
	        for (int k = 0; k <= grad; k++) {
	          rest[k] -= zwischenErgebnis[k];
	        }
	      }
	    }
	    
	  }

}
