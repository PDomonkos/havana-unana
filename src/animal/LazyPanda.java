package animal;

import java.util.ArrayList;
import java.util.List;

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
		myTile.Remove();
		a.Add(this);
		this.myTile = a;
		this.DisableSteps();
		System.out.println("beléptem");
	}
}
