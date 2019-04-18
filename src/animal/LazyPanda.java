package animal;

import def.Tester;
import tile.Armchair;

/**
 * Lusta pandát reprezentáló osztály
 *
 */
public class LazyPanda extends Panda {
	/**
	 * Reagál a szomszédos fotel jelenlétére
	 * 
	 * Elengedi a mögötte lévõ pandát, és beleül a fotelba
	 * 
	 * @param a adott fotel
	 */
	public void TakeASeat(Armchair a) {
		
		this.Let();
		a.Accept(this);
		this.DisableSteps();
		
	}
	
	@Override
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nTÍPUSOM: LazyPanda\nCSEMPE, AHOL ÁLLOK: %s\nKÖVETÕM:%s\nLÉPHETEK:%s\nVEZETÕM:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
