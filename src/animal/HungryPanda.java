package animal;

import def.Logger;

/**
 * �hes pand�t reprezent�l� oszt�ly
 *
 */
public class HungryPanda extends Panda {
	/**
	 * S�pol�s hat�s�ra ugrik egyet
	 * 
	 * A saj�t csemp�j�n megh�vja az addot
	 */
	public void ReactToBeep() {
		Logger.get_static_logger().enter(this, "ReactToBeep", null);
		
		myTile.Add(this);
		
		Logger.get_static_logger().exit(this, "ReactToBeep", null,"");
	}
}
