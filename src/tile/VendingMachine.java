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
///////////////////
		//nem kéne randomnak lennie?
		//vagy skelóba még nem
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.ReactToBeep();
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
/////////////////////
	//fasza
	public boolean Accept(Animal a) {
		return true; //hogy ne dobjon errort
	}
}
