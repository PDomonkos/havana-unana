package tile;
import animal.Animal;
import def.Logger;

/**
 * Csokiautomat�t reprezent�l� oszt�ly
 *
 */
public class VendingMachine extends Tile {
	/**
	 * L�p�s: n�ha s�pol, ami a szomsz�dos csemp�kig elhallatszik
	 */
	public void Step() {

		//random lesz majd
		for(Tile t: neighbours) {
			Animal a=t.GetAnimal();
			if (a!=null)
				a.ReactToBeep();
		}
		
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
}
