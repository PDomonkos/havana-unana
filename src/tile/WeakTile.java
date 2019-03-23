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

////////////////////
	//? minek ide
	//logge is elmaradt még
	public void Step() {
	}
	
////////////////////
	//ez kell?  ennyit se ad az öröklés?
	public Tile[] GetNeighbours() {
		Logger.get_static_logger().enter(this, "GetNeighbours", null);
		Logger.get_static_logger().exit(this, "GetNeighbours", null, "super.neighbours");
		return super.GetNeighbours();
	}
	
/////////////////////
	///ez szintén mi
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		if(super.getAnimal() == null) {
			a.Move(this);
		} else {
			super.getAnimal().HitBy(a);
		}
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a}, "true");
		
		return true;
	}

////////////////...
	public void Remove() {
	}

//////////////:???
	public Animal getAnimal() {
		return super.getAnimal();
	}
	
//////////////////////
	//ez ugye csak a diagramok miatt volt most már nem is kelle mert csak itt hívjuk
	//ugye? :D
	public void DecreaseCount() {
		Count--;
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
		
		DecreaseCount();
		if(Count == 0)
			a.Die();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
///////////////////////////
	//paraméteres konstruktor nem hasznosabb akkor már?
	// Skeletonhoz
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { this.Count = cnt; }
}
