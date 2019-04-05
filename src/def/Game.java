package def;
import animal.Animal;
import animal.Orangutan;
import tile.Tile;

/**
 * Játékot reprezentáló osztály
 */
public class Game {

	/**
	 * Csempék
	 */
	private Tile[] tiles;
	/**
	 * Állatok
	 */
	private Animal[] animals;
	
	/**
	 * Pálya generálása
	 */
	public void Generate() {
	}
	/**
	 * Pálya elemi között lévõ kapcsolatok beállítása
	 */
	public void Set() {
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
}
