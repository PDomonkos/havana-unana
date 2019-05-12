package tile;

import java.util.Random;

import animal.Animal;
import animal.Panda;
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
		
		if(myAnimal==null) {
			if (count==2){
			Random rand = new Random();
			int randomszam = rand.nextInt(10);
				for(Tile n: neighbours) {
					Animal a=n.GetAnimal();
					if (a!= null && randomszam % 2 == 0)
						a.TakeASeat(this);		
				}
			}
			else count++;
		}else {
			count--;
			System.out.println(count);
			if (count==0) {
				((Panda)myAnimal).EnableSteps();
			}
		}
	}
	
	/**
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
}
