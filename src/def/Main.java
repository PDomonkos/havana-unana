package def;
import java.util.Scanner;

/**
 * F� oszt�ly
 * 
 */
public class Main {
	public static Scanner in;
	
	/**
	 * Men� list�z�sa, v�lasztott szcen�ri� futtat�sa
	 * 
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {
		
		
		// static_logger inicializ�l�sa
		Logger.init_static_logger();
				
		// Scenario kivalasztasa es futtatasa
		
		in = new Scanner(System.in);
		String input="";

			
		in.close();
	}
}
