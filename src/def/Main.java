package def;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
//
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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Tester.execute(in);
	}
}
