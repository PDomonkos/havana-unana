package def;
import animal.Orangutan;
import tile.Tile;

/**
 * Játékot reprezentáló osztály
 */
public class Game {

	/**
	 * Pontot ad az adott orángutánnak
	 * 
	 * @param o orángután
	 */
	public void addPoint(Orangutan o) {
		Logger.get_static_logger().enter(this, "addPoint", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "addPoint", new Object[] {o}, "");
	}
	
	/**
	 * Vége a játéknak, az adott orángután vesztett
	 * 
	 * @param o vesztes orángután
	 */
	public void end(Orangutan o) {
		Logger.get_static_logger().enter(this, "end", new Object[] {o});
		
		Logger.get_static_logger().exit(this, "end", new Object[] {o}, "");
	}
}
