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
///////////////////
		//nem k�ne randomnak lennie?
		//vagy skel�ba m�g nem
		for(Tile n: neighbours) {
			Animal a=n.getAnimal();
			a.ReactToBeep();
		}
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
/////////////////////
	//fasza
	public boolean Accept(Animal a) {
		return true; //hogy ne dobjon errort
	}
}
