package tile;
import animal.Animal;
import def.Logger;

/**
 * Törékeny csempe
 *
 */
public class WeakTile extends Tile {
	/**
	 * csempe élettartama
	 */
	public int Count;

	/**
	 * Konstruktor, mindig 20 élete van
	 */
	public WeakTile(){
		this.Count = 20; 
	}
	
	/**
	 * számláló csökkentése
	 */
	private void DecreaseCount() {
		Logger.get_static_logger().enter(this, "DecreaseCount", null);
		
		Count--;
		
		Logger.get_static_logger().enter(this, "DecreaseCount", null);
	}
	
	/**
	 * Állat elhelyezésekor csökkenti az élettartamot, ha eltörik, az állat leesik
	 * 
	 * @param érkezõ állat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		
		//majd átírjuk die a decreasebe legyen
		DecreaseCount();
		if(Count == 0)
			a.Die();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
	// Skeletonhoz
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { this.Count = cnt; }
}
