package tile;

import animal.Animal;
import animal.Panda;
import def.Logger;

/**
 * Fotelt reprezent�l� oszt�ly
 *
 */
public class Armchair extends Tile {
	/**
	 * Sz�ml�l�
	 */
	int count;
	
	/**
	 * konstruktor: sz�ml�l� inicializ�l�sa
	 */
	public Armchair() {
		count=2;
	}
	
	/**
	 * L�p�s: 
	 * 
	 * Ha nincs benne �llat, jelez a szomsz�dainak, hogy �res fotel van a szomsz�djukban
	 * K�l�nben cs�kkenti a sz�ml�l�t, ha az nulla lett elengedi a benne �l� �llatot
	 */
	public void Step() {
		
		//v�letlenszer� ez is
		if(myAnimal==null) {
			for(Tile n: neighbours) {
				Animal a=n.GetAnimal();
				a.TakeASeat(this);		
			}
		}else {
			count--;
			if (count==0) {
				((Panda)myAnimal).EnableSteps();
				count=2;
			}
		}
		
		
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
}
