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
/////////////////
	//ez lehetne a szomszédja is?
	
	/**
	 * Állat érkezésekor azt a bejáratra továbbítja
	 */
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		// Nem kell leellenrizni, hogy áll-e rajta valaki, mivel olyan nem fordulhat elõ
		a.Move(entry);
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a}, "");
		
		return true;
	}
	
	/**
	 * Bejárat tárolása
	 * 
	 * @param en bejárat
	 */
	public void setEntry(Entry en) {
		entry = en;
	}
}
