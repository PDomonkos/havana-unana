package tile;

import animal.Animal;
import def.Logger;

/**
 * Fotelt reprezentáló osztály
 *
 */
public class Armchair extends Tile {
////////////////////////////
	//ide kéne valami kör számláló hogy meddig ült benne a lusta geci
	
	/**
	 * Lépés: jelez a szomszédainak, hogy üres fotel van a szomszédjukban
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.TakeASeat(this);
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
}
