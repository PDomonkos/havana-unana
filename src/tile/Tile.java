package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import def.Steppable;
import def.Tester;

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
	
	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) { 

		Tester.WriteOutput("SIKERTELEN L�TREHOZ�S", null);
		
	}
	
	///list miatt
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: Tile\n" + 
				"SZOMSZ�DAIM: ");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		for(int i=0; i<neighbours.length; i++) {
			obj.add(neighbours[i]);
			if(i==neighbours.length-1)
				base+= i+ " - %s\n";
			else
				base+= i+ " - %s, ";
		}
		
		if(myAnimal==null) 	
			base+= new String("A RAJTAM �LL� �LLAT: null");
		else {
			base+= new String("A RAJTAM �LL� �LLAT: %s");
			obj.add(myAnimal);
		}
		
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
