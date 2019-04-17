package tile;
import animal.Animal;
import def.Logger;

/**
 * Csokiautomatát reprezentáló osztály
 *
 */
public class VendingMachine extends Tile {
	/**
	 * Lépés: néha sípol, ami a szomszédos csempékig elhallatszik
	 */
	public void Step() {

		//random lesz majd
		for(Tile t: neighbours) {
			Animal a=t.GetAnimal();
			if (a!=null)
				a.ReactToBeep();
		}
		
	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
}
