package tile;
import animal.Animal;
import def.Logger;
import def.Steppable;

/**
 * Csempe õsosztály
 * 
 */
public class Tile implements Steppable {
	/**
	 * Szomszédos csempék tömbje
	 */
	protected Tile[] neighbours;
	/**
	 * Csempén lévõ állat
	 */
	protected Animal myAnimal;
	
	/**
	 * Csempe lép
	 * 
	 * Alapértelmezetten nem csinál semmit, a leszármazottakban lesz haszna
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Szomszédos csempék lekérdezése
	 * 
	 * @return szomszédos csempék
	 */
	public Tile[] GetNeighbours() {
		Logger.get_static_logger().enter(this, "GetNeighbours", null);
		Logger.get_static_logger().exit(this, "GetNeighbours", null, "neighbours");
		return neighbours;
	}
	
	/**
	 * Szomszédos csempék beállítása
	 * 
	 * @param t megadott csempék
	 */
	public void SetNeighbours(Tile[] t) {
		Logger.get_static_logger().enter(this, "SetNeighbours", t);
		
		neighbours=t;
		
		Logger.get_static_logger().exit(this, "SetNeighbours", t, "");
	}
	
	/**
	 * Csempe kezeli, ha rálépne egy állat
	 * 
	 * @param a érkezõ állat
	 * @return kuki
	 */
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		if(myAnimal==null)
			a.Move(this);
		else {
			myAnimal.HitBy(a);
		}

/////////////////////////
		//most itt direkt nincs paraméter?
		//egyáltalán kell exitnél paraméter? nem lehetne a paraméter a return?
		Logger.get_static_logger().exit(this, "Accept", null, "true");
//////////////
		//hát ennek valóban nincs értelme
		return true;
	}
	
	/**
	 * Állat csempére helyezése
	 * 
	 * @param a állat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
	
	/**
	 * Állat eltávolítása a csempérõl
	 * 
	 */
	public void Remove() {
		Logger.get_static_logger().enter(this, "Remove", null);
		
		myAnimal=null;
		
		Logger.get_static_logger().exit(this, "Remove", null, "");
	}
	
	/**
	 * Csempén lévõ állat lekérdezése
	 * 
	 * @return csempén lévõ állat
	 */
	public Animal getAnimal() {
		Logger.get_static_logger().enter(this, "getAnimal", null);
		Logger.get_static_logger().exit(this, "getAnimal", null, "myAnimal");
		
		return myAnimal;
	}
}
