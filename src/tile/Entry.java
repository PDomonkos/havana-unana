package tile;
import animal.Animal;
import animal.Orangutan;
import def.Logger;

/**
 * Bej�ratot reprezent�l� oszt�ly
 * 
 */
public class Entry extends Tile {
	/**
	 * Utolj�ra kij�v� or�ngut�n
	 */
	Orangutan myO;
	
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
	
	/**
	 * Ha panda ment �t rajta, akkor pontot ad a legutols� or�ngut�nnak
	 */
	public void addPoint() {
		Logger.get_static_logger().enter(this, "Add", null);
		
		Tile.game.addPoint(myO);
		
		Logger.get_static_logger().exit(this, "Add", null, "");
	}
	
	/**
	 * Ha or�ngut�n ment �t rajta, akkor be�ll�tja azt legutols� or�ngut�nnak
	 */
	public void setOrangutan (Orangutan o) {
		Logger.get_static_logger().enter(this, "Add", null);
		
		myO=o;
		
		Logger.get_static_logger().exit(this, "Add", null, "");
	}
}
