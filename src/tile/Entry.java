package tile;
import animal.Animal;
import def.Logger;

/**
 * Bejáratot reprezentáló osztály
 * 
 */
public class Entry extends Tile {
///////////
	//azért legyünk õszinték ez még nem teljes vagy csak én érzem úgy ? :D
	/**
	 * Állat hozzáadásakor meghívja rajta az exit függvényt
	 * 
	 * @param a érkezõ állat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		a.Exit();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
}
