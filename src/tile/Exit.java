package tile;

import java.util.ArrayList;
import java.util.List;


/**
 * Kijáratot reprezentáló osztály
 *
 */
public class Exit extends Tile {
	/**
	 * Bejáratost ismeri
	 */
	private Entry entry;
	
	/**
	 * Exit lép
	 * 
	 * Ha van rajta állat, átteszi az entryre
	 * Mivel nincs szomszédja az exitnek, nem lehet róla lelépni, csak a step által
	 */
	public void Step() {
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
	}
	
	/**
	 * Bejárat tárolása
	 * 
	 * @param en bejárat
	 */
	public void setEntry(Entry en) {
		
		entry = en;

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"TÍPUSOM: Exit\n" + 
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
