package tile;
import def.Logger;

/**
 * Kij�ratot reprezent�l� oszt�ly
 *
 */
public class Exit extends Tile {
	/**
	 * Bej�ratost ismeri
	 */
	private Entry entry;
	
	/**
	 * Exit l�p
	 * 
	 * Ha van rajta �llat, �tteszi az entryre
	 * Mivel nincs szomsz�dja az exitnek, nem lehet r�la lel�pni, csak a step �ltal
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Bej�rat t�rol�sa
	 * 
	 * @param en bej�rat
	 */
	public void setEntry(Entry en) {
		Logger.get_static_logger().enter(this, "setEntry", new Object[] {en});
		
		entry = en;
		
		Logger.get_static_logger().exit(this, "setEntry", new Object[] {en}, "");
	}
}
