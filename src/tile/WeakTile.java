package tile;
import animal.Animal;
import def.Logger;

/**
 * T�r�keny csempe
 *
 */
public class WeakTile extends Tile {
	/**
	 * csempe �lettartama
	 */
	private int count;

	/**
	 * Konstruktor, mindig 20 �lete van
	 */
	public WeakTile(){
		this.count = 20; 
	}
	
	/**
	 * sz�ml�l� cs�kkent�se
	 */
	private void DecreaseCount() {
		Logger.get_static_logger().enter(this, "DecreaseCount", null);
		
		count--;
		
		Logger.get_static_logger().exit(this, "DecreaseCount", null, "");
	}
	
	/**
	 * �llat elhelyez�sekor cs�kkenti az �lettartamot, ha elt�rik, az �llat leesik
	 * 
	 * @param �rkez� �llat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		
		//majd �t�rjuk die a decreasebe legyen
		DecreaseCount();
		if(count == 0)
			a.Die();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
	// Skeletonhoz
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { this.count = cnt; }
}
