package def;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
//
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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Tester.execute(in);
	}
}
