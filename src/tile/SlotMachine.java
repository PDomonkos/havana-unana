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
		
////////// random kell csilingelnie, most (skeletonban) minden esetben csilingel
		for (Tile t : neighbours) {
			t.getAnimal().ReactToJingle();
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
////////////////////////////	
	public boolean Accept(Animal a) {
		return true; //hogy ne dobjon errort
	}
}
