package animal;

import java.util.ArrayList;
import java.util.List;

/**
 * F�l�s pand�t reprezent�l� oszt�ly
 * 
 */
public class ShyPanda extends Panda {
	/**
	 * Csilingel�s hat�s�ra elengedi az eddig h�zott panda kez�t
	 */
	public void ReactToJingle() {
		if (follower != null)
			follower.Let();
	}
}
