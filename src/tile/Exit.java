package tile;
import animal.Animal;
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
	 * Állat érkezésekor azt a bejáratra továbbítja
	 *//*
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		// Nem kell leellenrizni, hogy áll-e rajta valaki, mivel olyan nem fordulhat elõ
		a.Move(entry);
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a}, "");
		
		return true;
	}*/
	
	/**
	 * Bejárat tárolása
	 * 
	 * @param en bejárat
	 */
	public void setEntry(Entry en) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {en});
		
		entry = en;
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {en}, "");
	}
}
