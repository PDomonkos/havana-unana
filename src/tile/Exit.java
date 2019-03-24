package tile;
import animal.Animal;
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
	 * �llat �rkez�sekor azt a bej�ratra tov�bb�tja
	 *//*
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		// Nem kell leellenrizni, hogy �ll-e rajta valaki, mivel olyan nem fordulhat el�
		a.Move(entry);
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a}, "");
		
		return true;
	}*/
	
	/**
	 * Bej�rat t�rol�sa
	 * 
	 * @param en bej�rat
	 */
	public void setEntry(Entry en) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {en});
		
		entry = en;
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {en}, "");
	}
}
