package animal;

import def.Tester;

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
		
		myTile.Add(this);
		
	}
	
	@Override
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nT�PUSOM: HungryPanda\nCSEMPE, AHOL �LLOK: %s\nK�VET�M:%s\nL�PHETEK:%s\nVEZET�M:%s", 
				new Object[] {this, myTile, follower, canStep, leader});
	}
}
