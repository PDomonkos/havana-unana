package animal;

import def.Logger;

/**
 * Éhes pandát reprezentáló osztály
 *
 */
public class HungryPanda extends Panda {
	/**
	 * Sípolás hatására ugrik egyet
	 * 
	 * A saját csempéjén meghívja az addot
	 */
	public void ReactToBeep() {
		Logger.get_static_logger().enter(this, "ReactToBeep", null);
		
		myTile.Add(this);
		
		Logger.get_static_logger().exit(this, "ReactToBeep", null,"");
	}
}
