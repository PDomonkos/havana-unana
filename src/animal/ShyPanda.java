package animal;

import def.Logger;

/**
 * F�l�s pand�t reprezent�l� oszt�ly
 * 
 */
public class ShyPanda extends Panda {
	/**
	 * Csilingel�s hat�s�ra elengedi az eddig h�zott panda kez�t
	 */
	public void ReactToJingle() {
		Logger.get_static_logger().enter(this, "ReactToJingle", null);
		
		if (follower != null)
			follower.Let();
		
		Logger.get_static_logger().exit(this, "ReactToJingle", null,"");
	}
}
