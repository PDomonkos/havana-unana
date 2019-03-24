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
		Logger.get_static_logger().enter(this, "Step", null);

		//random lesz majd
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.ReactToBeep();
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", null);
		Logger.get_static_logger().exit(this, "Accept", null, "");
	}
}
