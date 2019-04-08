package animal;

import def.Logger;

/**
 * Félõs pandát reprezentáló osztály
 * 
 */
public class ShyPanda extends Panda {
	/**
	 * Csilingelés hatására elengedi az eddig húzott panda kezét
	 */
	public void ReactToJingle() {
		Logger.get_static_logger().enter(this, "ReactToJingle", null);
		
		if (follower != null)
			follower.Let();
		
		Logger.get_static_logger().exit(this, "ReactToJingle", null,"");
	}
}
