package animal;

import java.util.ArrayList;
import java.util.List;

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
		myTile.Remove();
		a.Add(this);
		this.DisableSteps();
	}
	
	@Override
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "T�PUSOM: LazyPanda\n" + "CSEMPE, AHOL �LLOK: [%s]\n");
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

	}
}
