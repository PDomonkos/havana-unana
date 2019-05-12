package animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Félõs pandát reprezentáló osztály
 * 
 */
public class ShyPanda extends Panda {
	/**
	 * Csilingelés hatására elengedi az eddig húzott panda kezét
	 */
	public void ReactToJingle() {
		if (follower != null)
			follower.Let();
	}
}
