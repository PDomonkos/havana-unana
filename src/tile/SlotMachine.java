package tile;
import animal.Animal;

/**
 * Játékgépet reprezentáló osztály
 *
 */
public class SlotMachine extends Tile {
	/**
	 * Lépés: néha csilingel, ami a szomszédos csempékig elhallatszik
	 */
	public void Step() {

		//random lesz majd
		for (Tile t : neighbours) {
			t.GetAnimal().ReactToJingle();
		}

	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
}
