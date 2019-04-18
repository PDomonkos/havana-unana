package def;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Timer;

import animal.Orangutan;
import animal.Panda;
import tile.Armchair;
import tile.Cupboard;
import tile.Entry;
import tile.Exit;
import tile.SlotMachine;
import tile.Tile;
import tile.VendingMachine;
import tile.WeakTile;

/**
 * Játékot reprezentáló statikus osztály
 */
public class Game {

	/**
	 * Léptethetõ dolgok
	 */
	static private Steppable[] steppables;

	/**
	 * timer
	 */
	static private Timer timer;
	
	//ezt meg kéne oldani hogy hívja updatet
	
	/**
	 * pontok tárolása
	 */
	static private HashMap<Orangutan, Integer> points;
	
	/**
	 * Csak a protohoz, a csempék átadása a testernek
	 */
	private static HashMap<Object, String> things;
	
	/**
	 * Pálya generálása, és kapcsolatok beállítása
	 */
	public static void Generate(String inputFileName) {
		try {
			FileReader inputFR = new FileReader(inputFileName);
		
			BufferedReader inputBR=new BufferedReader(inputFR);
			String line;
		
			
			while((line=inputBR.readLine())!="") {
				StringTokenizer separate=new StringTokenizer(line," ");
				
				String name=separate.nextToken();
				switch(separate.nextToken()) {
					case "nt":  things.put(new Tile(), name); break;
					case "wt":  things.put(new WeakTile(), name); break;
					case "cb":  things.put(new Cupboard(), name); break;
					case "vm":  things.put(new VendingMachine(), name); break;
					case "sm":  things.put(new SlotMachine(), name); break;
					case "ac":  things.put(new Armchair(), name); break;
					case "en":  things.put(new Entry(), name); break;
					case "ex":  things.put(new Exit(), name); break;
				}
			}
			while((line=inputBR.readLine())!="") {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,": ");
				String name=separate1.nextToken();
				//, leválasztása
				StringTokenizer separate2=new StringTokenizer(line,", ");
				Tile[] neighbours;
				String neighbour;
				while(separate2.hasMoreTokens()) {
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Vége a játéknak, az adott orángután vesztett
	 * 
	 * @param o vesztes orángután
	 */
	public static void End(Orangutan o) {

	}
	
	/**
	 * Pontot ad az adott orángutánnak
	 * 
	 * @param o orángután
	 */
	public static void AddPoint(Orangutan o) {

	}
	
	/**
	 * Steppable eltávolítása
	 * 
	 * @param s az adott léptethetõ dolog
	 */
	public static void RemoveSteppable(Steppable s) {
		
	}
	
	/**
	 * Léptethetõ dolgok léptetése
	 */
	public static void Update() {
		
	}
	
	public HashMap<Object, String> GetObjects() {
		return things;
	}
}
