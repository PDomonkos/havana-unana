package animal;

import java.util.ArrayList;
import java.util.List;

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
		Tester.WriteOutput("UGROTT EGYET %s", new Object[] {this});
		myTile.Add(this);
	}
	
	@Override
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "TÍPUSOM: HungryPanda\n" + "CSEMPE, AHOL ÁLLOK: [%s]\n");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		obj.add(myTile);

		if (follower == null)
			base += new String("KÖVETÕM: null\n");
		
		else {
			base += new String("KÖVETÕM: %s\n");
			obj.add(follower);
		}
		
		if(canStep)
			base +=new String("LÉPHETEK: IGEN\n");
		else
			base +=new String("LÉPHETEK: NEM\n");
		
		if (leader == null)
			base += new String("VEZETÕM: null");
		else {
			base += new String("VEZETÕM: %s");
			obj.add(leader);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
