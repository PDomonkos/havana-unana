package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Orangutan;

/**
 * Bej�ratot reprezent�l� oszt�ly
 * 
 */
public class Entry extends Tile {
	/**
	 * Utolj�ra kij�v� or�ngut�n
	 */
	private Orangutan myO;
	
	/**
	 * �llat hozz�ad�sakor megh�vja rajta az exit f�ggv�nyt
	 * 
	 * @param a �rkez� �llat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;
		a.Exit();
		
	}
	
	/**
	 * Ha panda ment �t rajta, akkor pontot ad a legutols� or�ngut�nnak
	 */
	public void AddPoint() {
		
		if (myO != null)
			myO.AddPoint();
		
	}
	
	/**
	 * Ha or�ngut�n ment �t rajta, akkor be�ll�tja azt legutols� or�ngut�nnak
	 */
	public void SetOrangutan (Orangutan o) {
		
		myO=o;
		
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
}
