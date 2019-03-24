package tile;

import java.util.Random;

import animal.Animal;
import def.Logger;

/**
 * Szekrényt reprezentáló osztály
 *
 */
public class Cupboard extends Tile {
	
	Cupboard[] cupboards;
	
	public void SetCupboards(Cupboard[] c) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {c});
		
		cupboards=c;
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {c},"");
		
	}
	
	public boolean Accept(Animal a) {
		Logger.get_static_logger().enter(this, "Accept", new Object[] {a});
		
		Animal oldAnimal=myAnimal;
		
		if(!myAnimal.equals(null)) myAnimal.HitBy(a);
		else {
			Random rand=new Random();
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		//Orángután elkapja a pandát esetben fut le (csak ekkor változik az állat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		
		Logger.get_static_logger().exit(this, "Accept", new Object[] {a},"");
		return true;
	}
	
	public void Step() {
		
	}
}
