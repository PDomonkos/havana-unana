package tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
import def.Tester;

/**
 * Szekrényt reprezentáló osztály
 *
 */
public class Cupboard extends Tile {
	/**
	 * szomszédos szekrények
	 */
	private Cupboard[] cupboards = null;
	
	/**
	 * Beállítja a szomszédos szekrényeit
	 */
	public void SetCupboards(Cupboard[] c) {
		
		cupboards=c;
		
	}
	
	/**
	 * Állat lép a szekrénybe
	 * 
	 * Ha állat állt rajta akkor ütköztet, ha nincs mozgatja egy szomszédra
	 * ha elkapott egy orángután egy pandát akkor az orángután átrakja
	 */
	public void Accept(Animal a) {
		
		Animal oldAnimal=myAnimal;
		
		if(myAnimal!=null) myAnimal.HitBy(a);
		else {
			Random rand=new Random();
			//üresség ellenõrzése
			if (cupboards != null)
				a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		//Orángután elkapja a pandát esetben fut le (csak ekkor változik az állat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			//üresség ellenõrzése itt is
			if (cupboards != null)
				a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"TÍPUSOM: Cupboard\n" + 
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
