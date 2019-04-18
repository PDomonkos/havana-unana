package tile;
import animal.Animal;

/**
 * Törékeny csempe
 *
 */
public class WeakTile extends Tile {
	/**
	 * csempe élettartama
	 */
	private int count;

	/**
	 * Konstruktor, mindig 20 élete van
	 */
	public WeakTile(){
		this.count = 20; 
	}
	
	/**
	 * számláló csökkentése
	 */
	private void DecreaseCount() {
		
		count--;

	}
	
	/**
	 * Állat elhelyezésekor csökkenti az élettartamot, ha eltörik, az állat leesik
	 * 
	 * @param érkezõ állat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;
		
		//majd átírjuk die a decreasebe legyen
		DecreaseCount();
		if(count == 0)
			a.Die();
		
	}
	
	// Skeletonhoz
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { this.count = cnt; }
}
