package def;
import java.util.HashMap;
import java.util.Timer;

import animal.Orangutan;
import animal.Panda;

import tile.Tile;

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
	 * P�lya gener�l�sa, �s kapcsolatok be�ll�t�sa
	 */
	public static void Generate() {
		Tile[] tiles;
		Panda[] pandas;
		Orangutan[] orangutans;
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
}
