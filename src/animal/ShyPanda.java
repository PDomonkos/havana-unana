package animal;

import java.util.ArrayList;
import java.util.List;

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
		String base = new String("NEVEM: %s\n" + "T�PUSOM: ShyPanda\n" + "CSEMPE, AHOL �LLOK: [%s]\n");
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
			base +=new String("L�PHETEK: IGEN\n");
		else
			base +=new String("L�PHETEK: NEM\n");
		
		if (leader == null)
			base += new String("VEZET�M: null");
		else {
			base += new String("VEZET�M: %s");
			obj.add(leader);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();
		Tester.WriteOutput(base, objArr);
	}

}
