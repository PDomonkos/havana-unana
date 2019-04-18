package animal;

import def.Tester;

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
	
	@Override
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nTÍPUSOM: HungryPanda\nCSEMPE, AHOL ÁLLOK: %s\nKÖVETÕM:%s\nLÉPHETEK:%s\nVEZETÕM:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
