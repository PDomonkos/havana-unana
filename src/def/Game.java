package def;
import java.util.HashMap;
import java.util.Timer;

import animal.Animal;
import animal.Orangutan;
import tile.Tile;

/**
 * J�t�kot reprezent�l� oszt�ly
 */
public static class Game {

	/**
	 * L�ptethet� dolgok
	 */
	private Steppable[] steppables;

	/**
	 * timer
	 */
	private Timer timer;
	
	//ezt meg k�ne oldani hogy h�vja updatet
	
	/**
	 * pontok t�rol�sa
	 */
	private HashMap<Orangutan, Integer> points;
	
	/**
	 * P�lya gener�l�sa, �s kapcsolatok be�ll�t�sa
	 */
	public void Generate() {
		Tile[] tiles;
		Panda[] pandas;
		Orangutan[] orangutans;
	}
	
	/**
	 * V�ge a j�t�knak, az adott or�ngut�n vesztett
	 * 
	 * @param o vesztes or�ngut�n
	 */
	public void End(Orangutan o) {
		Logger.get_static_logger().enter(this, "end", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "end", new Object[] {o}, "");
	}
	
	/**
	 * Pontot ad az adott or�ngut�nnak
	 * 
	 * @param o or�ngut�n
	 */
	public void AddPoint(Orangutan o) {
		Logger.get_static_logger().enter(this, "addPoint", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "addPoint", new Object[] {o}, "");
	}
	
	/**
	 * Steppable elt�vol�t�sa
	 * 
	 * @param s az adott l�ptethet� dolog
	 */
	public void removeSteppable(Steppable s) {
		
	}
	
	/**
	 * L�ptethet� dolgok l�ptet�se
	 */
	public void Update() {
		
	}
}
