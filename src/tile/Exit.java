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
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
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
