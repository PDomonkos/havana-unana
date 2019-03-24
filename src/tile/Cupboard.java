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
	Cupboard[] cupboards;
	
	/**
	 * Be�ll�tja a szomsz�dos szekr�nyeit
	 */
	public void SetCupboards(Cupboard[] c) {
		Logger.get_static_logger().enter(this, "SetCupboards", new Object[] {c});
		
		cupboards=c;
		
		Logger.get_static_logger().exit(this, "SetCupboards", new Object[] {c},"");
		
	}
	
	/**
	 * �llat l�p a szekr�nybe
	 * 
	 * Ha �llat �llt rajta akkor �tk�ztet, ha nincs mozgatja egy szomsz�dra
	 * ha elkapott egy or�ngut�n egy pand�t akkor az or�ngut�n �trakja
	 */
	public void Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		Animal oldAnimal=myAnimal;
		
		if(myAnimal!=null) myAnimal.HitBy(a);
		else {
			Random rand=new Random();
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		//Or�ngut�n elkapja a pand�t esetben fut le (csak ekkor v�ltozik az �llat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a},"");
	}
	
}
