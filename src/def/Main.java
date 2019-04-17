package def;
import java.util.Scanner;

/**
 * Fõ osztály
 * 
 */
public class Main {
	public static Scanner in;
	
	/**
	 * Menü listázása, választott szcenárió futtatása
	 * 
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {
		
		
		// static_logger inicializálása
		Logger.init_static_logger();
				
		// Scenario kivalasztasa es futtatasa
		
		in = new Scanner(System.in);
		String input="";

			
		in.close();
	}
}
