package animal;

import java.util.ArrayList;
import java.util.List;

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
		
		Tester.WriteOutput("%s LEÜLT ITT: %s", new Object[] {this,a});
	}
	
	@Override
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "TÍPUSOM: LazyPanda\n" + "CSEMPE, AHOL ÁLLOK: %s\n");
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
