package tile;
import def.Logger;

/**
 * Kijáratot reprezentáló osztály
 *
 */
public class Exit extends Tile {
	/**
	 * Bejáratost ismeri
	 */
	private Entry entry;
	
	/**
	 * Exit lép
	 * 
	 * Ha van rajta állat, átteszi az entryre
	 * Mivel nincs szomszédja az exitnek, nem lehet róla lelépni, csak a step által
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Bejárat tárolása
	 * 
	 * @param en bejárat
	 */
	public void setEntry(Entry en) {
		Logger.get_static_logger().enter(this, "setEntry", new Object[] {en});
		
		entry = en;
		
		Logger.get_static_logger().exit(this, "setEntry", new Object[] {en}, "");
	}
}
