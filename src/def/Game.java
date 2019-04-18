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
 * J�t�kot reprezent�l� statikus oszt�ly
 */
public class Game {

	/**
	 * L�ptethet� dolgok
	 */
	static private Steppable[] steppables;

	/**
	 * timer
	 */
	static private Timer timer;
	
	//ezt meg k�ne oldani hogy h�vja updatet
	
	/**
	 * pontok t�rol�sa
	 */
	static private HashMap<Orangutan, Integer> points;
	
	/**
	 * Csak a protohoz, a csemp�k �tad�sa a testernek
	 */
	private static HashMap<Object, String> things;
	
	/**
	 * P�lya gener�l�sa, �s kapcsolatok be�ll�t�sa
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
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,": ");
				String name=separate1.nextToken();
				//, lev�laszt�sa
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
	 * V�ge a j�t�knak, az adott or�ngut�n vesztett
	 * 
	 * @param o vesztes or�ngut�n
	 */
	public static void End(Orangutan o) {

	}
	
	/**
	 * Pontot ad az adott or�ngut�nnak
	 * 
	 * @param o or�ngut�n
	 */
	public static void AddPoint(Orangutan o) {

	}
	
	/**
	 * Steppable elt�vol�t�sa
	 * 
	 * @param s az adott l�ptethet� dolog
	 */
	public static void RemoveSteppable(Steppable s) {
		
	}
	
	/**
	 * L�ptethet� dolgok l�ptet�se
	 */
	public static void Update() {
		
	}
	
	public HashMap<Object, String> GetObjects() {
		return things;
	}
}
