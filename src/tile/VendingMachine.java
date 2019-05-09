package tile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
/**
 * Csokiautomat�t reprezent�l� oszt�ly
 *
 */
public class VendingMachine extends Tile {
	/**
	 * L�p�s: n�ha s�pol, ami a szomsz�dos csemp�kig elhallatszik
	 */
	public void Step() {

			for (Tile t : neighbours) {
				Animal a=t.GetAnimal();
				if (a != null)
					a.ReactToBeep();
			}
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: VendingMachine\n" + 
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
		
		base+= new String("A RAJTAM �LL� �LLAT: null");
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
	}
}
