package tile;

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
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
	}
	
	/**
	 * Bej�rat t�rol�sa
	 * 
	 * @param en bej�rat
	 */
	public void setEntry(Entry en) {
		
		entry = en;

	}
}
