package animal;

import def.Tester;

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
	
	@Override
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nTÍPUSOM: ShyPanda\nCSEMPE, AHOL ÁLLOK: %s\nKÖVETÕM:%s\nLÉPHETEK:%s\nVEZETÕM:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
