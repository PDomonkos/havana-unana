package tile;
import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import def.Tester;

/**
 * J�t�kg�pet reprezent�l� oszt�ly
 *
 */
public class SlotMachine extends Tile {
	/**
	 * L�p�s: n�ha csilingel, ami a szomsz�dos csemp�kig elhallatszik
	 */
	public void Step() {

		//random lesz majd
		for (Tile t : neighbours) {
			t.GetAnimal().ReactToJingle();
		}

	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: SlotMachine\n" + 
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
		
		base+= new String("A RAJTAM �LL� �LLAT: null\n");
		
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
