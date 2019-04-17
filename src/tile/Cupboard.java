package tile;

import java.util.Random;

import animal.Animal;
import def.Logger;

/**
 * Szekrényt reprezentáló osztály
 *
 */
public class Cupboard extends Tile {
	/**
	 * szomszédos szekrények
	 */
	private Cupboard[] cupboards;
	
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
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		//Orángután elkapja a pandát esetben fut le (csak ekkor változik az állat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			//üresség ellenõrzése itt is
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
	}
	
}
