package tile;

import java.util.Random;

import animal.Animal;
import def.Logger;

/**
 * Szekr�nyt reprezent�l� oszt�ly
 *
 */
public class Cupboard extends Tile {
	/**
	 * szomsz�dos szekr�nyek
	 */
	private Cupboard[] cupboards;
	
	/**
	 * Be�ll�tja a szomsz�dos szekr�nyeit
	 */
	public void SetCupboards(Cupboard[] c) {
		
		cupboards=c;
		
	}
	
	/**
	 * �llat l�p a szekr�nybe
	 * 
	 * Ha �llat �llt rajta akkor �tk�ztet, ha nincs mozgatja egy szomsz�dra
	 * ha elkapott egy or�ngut�n egy pand�t akkor az or�ngut�n �trakja
	 */
	public void Accept(Animal a) {
		
		Animal oldAnimal=myAnimal;
		
		if(myAnimal!=null) myAnimal.HitBy(a);
		else {
			Random rand=new Random();
			//�ress�g ellen�rz�se
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		//Or�ngut�n elkapja a pand�t esetben fut le (csak ekkor v�ltozik az �llat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			//�ress�g ellen�rz�se itt is
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
	}
	
}
