package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Orangutan;
import def.Tester;

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
		
		myO.AddPoint();
		
	}
	
	/**
	 * Ha or�ngut�n ment �t rajta, akkor be�ll�tja azt legutols� or�ngut�nnak
	 */
	public void SetOrangutan (Orangutan o) {
		
		myO=o;
		
	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: Entry\n" + 
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
	}
}
