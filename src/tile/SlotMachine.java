package tile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
import def.Tester;

/**
 * Játékgépet reprezentáló osztály
 *
 */
public class SlotMachine extends Tile {
	/**
	 * Lépés: néha csilingel, ami a szomszédos csempékig elhallatszik
	 */
	public void Step() {

		if (!Tester.isRandom) {
			for (Tile t : neighbours) {
				Animal a=t.GetAnimal();
				if (a != null)
					a.ReactToJingle();
			}
			Tester.WriteOutput("CSILINGELÉS VOLT ITT: ", new Object[] {this});
		}
		else{
			Random rand = new Random();
			int r=rand.nextInt( 10 );
			if(r>6) {
				for (Tile t : neighbours) {
					Animal a=t.GetAnimal();
					if (a != null)
						a.ReactToJingle();
				}
				Tester.WriteOutput("CSILINGELÉS VOLT ITT: ", new Object[] {this});
			}
		}
		
	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"TÍPUSOM: SlotMachine\n" + 
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
		
		base+= new String("A RAJTAM ÁLLÓ ÁLLAT: null\n");
		
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
