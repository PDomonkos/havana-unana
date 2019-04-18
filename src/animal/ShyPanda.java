package animal;

import java.util.ArrayList;
import java.util.List;

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
		/*
		 * Tester.WriteOutput(
		 * "NEVEM: %s\nTÍPUSOM: ShyPanda\nCSEMPE, AHOL ÁLLOK: %s\nKÖVETÕM:%s\nLÉPHETEK:%s\nVEZETÕM:%s"
		 * , new Object[] {this, myTile, follower, canStep, leader});
		 */

		String base = new String("NEVEM: %s\n" + "TÍPUSOM: ShyPanda\n" + "CSEMPE, AHOL ÁLLOK: %s\n");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);

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
