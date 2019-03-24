package tile;
import animal.Animal;
import def.Logger;

/**
 * Játékgépet reprezentáló osztály
 *
 */
public class SlotMachine extends Tile {
	/**
	 * Lépés: néha csilingel, ami a szomszédos csempékig elhallatszik
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		//random lesz majd
		for (Tile t : neighbours) {
			t.getAnimal().ReactToJingle();
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
