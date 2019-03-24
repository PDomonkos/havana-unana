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
		Logger.get_static_logger().enter(this, "Step", null);

		//random lesz majd
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.ReactToBeep();
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", null);
		Logger.get_static_logger().exit(this, "Accept", null, "");
	}
}
