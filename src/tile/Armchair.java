package tile;

import java.util.Random;

import animal.Animal;
import animal.Panda;
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
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
}
