package def;
import animal.Animal;
import animal.Orangutan;
import tile.Tile;

/**
 * J�t�kot reprezent�l� oszt�ly
 */
public class Game {

	/**
	 * Csemp�k
	 */
	private Tile[] tiles;
	/**
	 * �llatok
	 */
	private Animal[] animals;
	
	/**
	 * P�lya gener�l�sa
	 */
	public void Generate() {
	}
	/**
	 * P�lya elemi k�z�tt l�v� kapcsolatok be�ll�t�sa
	 */
	public void Set() {
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
}
