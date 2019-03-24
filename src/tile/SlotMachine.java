package tile;
import animal.Animal;
import def.Logger;

/**
 * J�t�kg�pet reprezent�l� oszt�ly
 *
 */
public class SlotMachine extends Tile {
	/**
	 * L�p�s: n�ha csilingel, ami a szomsz�dos csemp�kig elhallatszik
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		//random lesz majd
		for (Tile t : neighbours) {
			t.getAnimal().ReactToJingle();
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
