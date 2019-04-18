package tile;
import animal.Animal;
import def.Steppable;

/**
 * Csempe �soszt�ly
 * 
 */
public class Tile implements Steppable {
		
	/**
	 * Szomsz�dos csemp�k t�mbje
	 */
	protected Tile[] neighbours;
	/**
	 * Csemp�n l�v� �llat
	 */
	protected Animal myAnimal;
	
	public Tile() {
		neighbours=null;
		myAnimal=null;
	}
	
	/**
	 * Csempe l�p
	 * 
	 * Alap�rtelmezetten nem csin�l semmit, a lesz�rmazottakban lesz haszna
	 */
	public void Step() {

	}
	
	/**
	 * Szomsz�dos csemp�k lek�rdez�se
	 * 
	 * @return szomsz�dos csemp�k
	 */
	public Tile[] GetNeighbours() {
		return neighbours;
	}
	
	/**
	 * Szomsz�dos csemp�k be�ll�t�sa
	 * 
	 * @param t megadott csemp�k
	 */
	public void SetNeighbours(Tile[] t) {
		
		neighbours=t;
		
	}
	
	/**
	 * Csempe kezeli, ha r�l�pne egy �llat
	 * 
	 * @param a �rkez� �llat
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
	 * �llat csemp�re helyez�se
	 * 
	 * @param a �llat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;

	}
	
	/**
	 * �llat elt�vol�t�sa a csemp�r�l
	 * 
	 */
	public void Remove() {
		
		myAnimal=null;

	}
	
	/**
	 * Csemp�n l�v� �llat lek�rdez�se
	 * 
	 * @return csemp�n l�v� �llat
	 */
	public Animal GetAnimal() {
		
		return myAnimal;
	}
}
