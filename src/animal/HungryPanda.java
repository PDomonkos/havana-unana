package animal;

import java.util.ArrayList;
import java.util.List;


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

		myTile.Add(this);
	}
	
}
