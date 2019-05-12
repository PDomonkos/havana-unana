package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Orangutan;

/**
 * Bejáratot reprezentáló osztály
 * 
 */
public class Entry extends Tile {
	/**
	 * Utoljára kijövõ orángután
	 */
	private Orangutan myO;
	
	/**
	 * Állat hozzáadásakor meghívja rajta az exit függvényt
	 * 
	 * @param a érkezõ állat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;
		a.Exit();
		
	}
	
	/**
	 * Ha panda ment át rajta, akkor pontot ad a legutolsó orángutánnak
	 */
	public void AddPoint() {
		
		if (myO != null)
			myO.AddPoint();
		
	}
	
	/**
	 * Ha orángután ment át rajta, akkor beállítja azt legutolsó orángutánnak
	 */
	public void SetOrangutan (Orangutan o) {
		
		myO=o;
		
	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
}
