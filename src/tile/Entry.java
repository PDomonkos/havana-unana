package tile;
import animal.Animal;
import def.Logger;

/**
 * Bej�ratot reprezent�l� oszt�ly
 * 
 */
public class Entry extends Tile {
///////////
	//az�rt legy�nk �szint�k ez m�g nem teljes vagy csak �n �rzem �gy ? :D
	/**
	 * �llat hozz�ad�sakor megh�vja rajta az exit f�ggv�nyt
	 * 
	 * @param a �rkez� �llat
	 */
	public void Add(Animal a) {
		Logger.get_static_logger().enter(this, "Add", new Object[] {a});
		
		a.SetTile(this);
		myAnimal=a;
		a.Exit();
		
		Logger.get_static_logger().exit(this, "Add", new Object[] {a}, "");
	}
}
