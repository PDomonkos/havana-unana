package tile;

import animal.Animal;
import def.Logger;

/**
 * Fotelt reprezent�l� oszt�ly
 *
 */
public class Armchair extends Tile {
////////////////////////////
	//ide k�ne valami k�r sz�ml�l� hogy meddig �lt benne a lusta geci
	
	/**
	 * L�p�s: jelez a szomsz�dainak, hogy �res fotel van a szomsz�djukban
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
