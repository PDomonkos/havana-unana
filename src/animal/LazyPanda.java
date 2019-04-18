package animal;

import def.Tester;
import tile.Armchair;

/**
 * Lusta pand�t reprezent�l� oszt�ly
 *
 */
public class LazyPanda extends Panda {
	/**
	 * Reag�l a szomsz�dos fotel jelenl�t�re
	 * 
	 * Elengedi a m�g�tte l�v� pand�t, �s bele�l a fotelba
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
				"NEVEM: %s\nT�PUSOM: LazyPanda\nCSEMPE, AHOL �LLOK: %s\nK�VET�M:%s\nL�PHETEK:%s\nVEZET�M:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
