package tile;

import animal.Animal;
import animal.Panda;
import def.Logger;

/**
 * Fotelt reprezentáló osztály
 *
 */
public class Armchair extends Tile {
	/**
	 * Számláló
	 */
	int count;
	
	/**
	 * konstruktor: számláló inicializálása
	 */
	public Armchair() {
		count=2;
	}
	
	/**
	 * Lépés: 
	 * 
	 * Ha nincs benne állat, jelez a szomszédainak, hogy üres fotel van a szomszédjukban
	 * Különben csökkenti a számlálót, ha az nulla lett elengedi a benne ülõ állatot
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if(myAnimal==null) {
			for(Tile n: neighbours) {
				Animal a=n.getAnimal();
				a.TakeASeat(this);		
			}
		}else {
			count--;
			if (count==0) {
				((Panda)myAnimal).EnableSteps();
				count=2;
			}
		}
		
		
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
}
