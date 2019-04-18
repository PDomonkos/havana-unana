package tile;
import animal.Animal;

/**
 * J�t�kg�pet reprezent�l� oszt�ly
 *
 */
public class SlotMachine extends Tile {
	/**
	 * L�p�s: n�ha csilingel, ami a szomsz�dos csemp�kig elhallatszik
	 */
	public void Step() {

		//random lesz majd
		for (Tile t : neighbours) {
			t.GetAnimal().ReactToJingle();
		}

	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
}
