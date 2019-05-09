package tile;

import java.util.ArrayList;
import java.util.List;


/**
 * Kij�ratot reprezent�l� oszt�ly
 *
 */
public class Exit extends Tile {
	/**
	 * Bej�ratost ismeri
	 */
	private Entry entry;
	
	/**
	 * Exit l�p
	 * 
	 * Ha van rajta �llat, �tteszi az entryre
	 * Mivel nincs szomsz�dja az exitnek, nem lehet r�la lel�pni, csak a step �ltal
	 */
	public void Step() {
		
		if (myAnimal != null)
			myAnimal.Move(entry);
		
	}
	
	/**
	 * Bej�rat t�rol�sa
	 * 
	 * @param en bej�rat
	 */
	public void setEntry(Entry en) {
		
		entry = en;

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: Exit\n" + 
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
