package def;
import java.util.HashMap;
import java.util.Timer;

import animal.Animal;
import animal.Orangutan;
import tile.Tile;

/**
 * Játékot reprezentáló osztály
 */
public static class Game {

	/**
	 * Léptethetõ dolgok
	 */
	private Steppable[] steppables;

	/**
	 * timer
	 */
	private Timer timer;
	
	//ezt meg kéne oldani hogy hívja updatet
	
	/**
	 * pontok tárolása
	 */
	private HashMap<Orangutan, Integer> points;
	
	/**
	 * Pálya generálása, és kapcsolatok beállítása
	 */
	public void Generate() {
		Tile[] tiles;
		Panda[] pandas;
		Orangutan[] orangutans;
	}
	
	/**
	 * Vége a játéknak, az adott orángután vesztett
	 * 
	 * @param o vesztes orángután
	 */
	public void End(Orangutan o) {
		Logger.get_static_logger().enter(this, "end", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "end", new Object[] {o}, "");
	}
	
	/**
	 * Pontot ad az adott orángutánnak
	 * 
	 * @param o orángután
	 */
	public void AddPoint(Orangutan o) {
		Logger.get_static_logger().enter(this, "addPoint", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "addPoint", new Object[] {o}, "");
	}
	
	/**
	 * Steppable eltávolítása
	 * 
	 * @param s az adott léptethetõ dolog
	 */
	public void removeSteppable(Steppable s) {
		
	}
	
	/**
	 * Léptethetõ dolgok léptetése
	 */
	public void Update() {
		
	}
}
