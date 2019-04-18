package tile;
import animal.Animal;
import def.Steppable;
import def.Tester;

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
	
	public Tile() {
		neighbours=null;
		myAnimal=null;
	}
	
	/**
	 * Csempe lép
	 * 
	 * Alapértelmezetten nem csinál semmit, a leszármazottakban lesz haszna
	 */
	public void Step() {

	}
	
	/**
	 * Szomszédos csempék lekérdezése
	 * 
	 * @return szomszédos csempék
	 */
	public Tile[] GetNeighbours() {
		return neighbours;
	}
	
	/**
	 * Szomszédos csempék beállítása
	 * 
	 * @param t megadott csempék
	 */
	public void SetNeighbours(Tile[] t) {
		
		neighbours=t;
		
	}
	
	/**
	 * Csempe kezeli, ha rálépne egy állat
	 * 
	 * @param a érkezõ állat
	 * @return kuki
	 */
	public void Accept(Animal a) {
		
		if(myAnimal==null)
			a.Move(this);
		else {
			myAnimal.HitBy(a);
		}

	}
	
	/**
	 * Állat csempére helyezése
	 * 
	 * @param a állat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;

	}
	
	/**
	 * Állat eltávolítása a csempérõl
	 * 
	 */
	public void Remove() {
		
		myAnimal=null;

	}
	
	/**
	 * Csempén lévõ állat lekérdezése
	 * 
	 * @return csempén lévõ állat
	 */
	public Animal GetAnimal() {
		
		return myAnimal;
	}
	
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { 

		Tester.WriteOutput("SIKERTELEN LÉTREHOZÁS", null);
		
	}
	
	///list miatt
	public void ListAttributes() {
		
	}
}
