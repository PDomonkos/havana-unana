package def;
import java.util.HashMap;
import java.util.Timer;

import animal.Animal;
import animal.Orangutan;
import animal.Panda;
import tile.Tile;

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
	 * Pálya generálása, és kapcsolatok beállítása
	 */
	public static void Generate() {
		Tile[] tiles;
		Panda[] pandas;
		Orangutan[] orangutans;
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
}
