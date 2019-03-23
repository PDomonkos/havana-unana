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
	public int Count;

////////////////////
	//? minek ide
	//logge is elmaradt m�g
	public void Step() {
	}
	
////////////////////
	//ez kell?  ennyit se ad az �r�kl�s?
	public Tile[] GetNeighbours() {
		Logger.get_static_logger().enter(this, "GetNeighbours", null);
		Logger.get_static_logger().exit(this, "GetNeighbours", null, "super.neighbours");
		return super.GetNeighbours();
	}
	
/////////////////////
	///ez szint�n mi
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
	//ez ugye csak a diagramok miatt volt most m�r nem is kelle mert csak itt h�vjuk
	//ugye? :D
	public void DecreaseCount() {
		Count--;
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
		
		DecreaseCount();
		if(Count == 0)
			a.Die();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
///////////////////////////
	//param�teres konstruktor nem hasznosabb akkor m�r?
	// Skeletonhoz
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { this.Count = cnt; }
}
