package animal;

import def.Logger;
import tile.Armchair;

/**
 * Lusta pandát reprezentáló osztály
 *
 */
public class LazyPanda extends Panda {
	/**
	 * Reagál a szomszédos fotel jelenlétére
	 * 
	 * Elengedi a mögötte lévõ pandát, és beleül a fotelba
	 * 
	 * @param a adott fotel
	 */
	public void TakeASeat(Armchair a) {
		Logger.get_static_logger().enter(this, "TakeASeat", null);
		
		this.Let();
		a.Accept(this);
		this.DisableSteps();
		
		Logger.get_static_logger().exit(this, "TakeASeat", null, "");
	}
}
