package animal;

import java.util.ArrayList;
import java.util.List;

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
		this.myTile = a;
		this.DisableSteps();
		System.out.println("bel�ptem");
	}
}
