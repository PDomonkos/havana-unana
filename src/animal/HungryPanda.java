package animal;

import java.util.ArrayList;
import java.util.List;

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
		
		Tester.WriteOutput("UGROTT EGYETT", new Object[] {this});
	}
	
	@Override
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "T�PUSOM: HungryPanda\n" + "CSEMPE, AHOL �LLOK: %s\n");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		obj.add(myTile);

		if (follower == null)
			base += new String("K�VET�M: null\n");
		
		else {
			base += new String("K�VET�M: %s\n");
			obj.add(follower);
		}
		
		if(canStep)
			base +=new String("L�PHETEK: true\n");
		else
			base +=new String("L�PHETEK: false\n");
		
		if (leader == null)
			base += new String("VEZET�M: null\n");
		else {
			base += new String("VEZET�M: %s\n");
			obj.add(leader);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
