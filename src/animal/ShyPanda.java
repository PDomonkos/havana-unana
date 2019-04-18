package animal;

import def.Tester;

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
	
	@Override
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nT�PUSOM: ShyPanda\nCSEMPE, AHOL �LLOK: %s\nK�VET�M:%s\nL�PHETEK:%s\nVEZET�M:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
