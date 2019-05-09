package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import animal.Orangutan;
import def.Tester;

/**
 * Bejáratot reprezentáló osztály
 * 
 */
public class Entry extends Tile {
	/**
	 * Utoljára kijövõ orángután
	 */
	private Orangutan myO;
	
	/**
	 * Állat hozzáadásakor meghívja rajta az exit függvényt
	 * 
	 * @param a érkezõ állat
	 */
	public void Add(Animal a) {
		
		a.SetTile(this);
		myAnimal=a;
		a.Exit();
		
	}
	
	/**
	 * Ha panda ment át rajta, akkor pontot ad a legutolsó orángutánnak
	 */
	public void AddPoint() {
		
		myO.AddPoint();
		
	}
	
	/**
	 * Ha orángután ment át rajta, akkor beállítja azt legutolsó orángutánnak
	 */
	public void SetOrangutan (Orangutan o) {
		
		myO=o;
		
	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"TÍPUSOM: Entry\n" + 
				"SZOMSZÉDAIM: ");
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
			base+= new String("A RAJTAM ÁLLÓ ÁLLAT: null");
		else {
			base+= new String("A RAJTAM ÁLLÓ ÁLLAT: %s");
			obj.add(myAnimal);
		}
		
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
	}
}
