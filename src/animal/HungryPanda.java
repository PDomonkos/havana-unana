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
		
		myTile.Add(this);
		
		Tester.WriteOutput("UGROTT EGYETT", new Object[] {this});
	}
	
	@Override
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "TÍPUSOM: HungryPanda\n" + "CSEMPE, AHOL ÁLLOK: %s\n");
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
			base +=new String("LÉPHETEK: true\n");
		else
			base +=new String("LÉPHETEK: false\n");
		
		if (leader == null)
			base += new String("VEZETÕM: null\n");
		else {
			base += new String("VEZETÕM: %s\n");
			obj.add(leader);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
