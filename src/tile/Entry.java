package tile;
import animal.Animal;
import animal.Orangutan;
import def.Logger;

/**
 * Bejáratot reprezentáló osztály
 * 
 */
public class Entry extends Tile {
	/**
	 * Utoljára kijövõ orángután
	 */
	Orangutan myO;
	
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
	
	/**
	 * Ha panda ment át rajta, akkor pontot ad a legutolsó orángutánnak
	 */
	public void addPoint() {
		Logger.get_static_logger().enter(this, "Add", null);
		
		Tile.game.addPoint(myO);
		
		Logger.get_static_logger().exit(this, "Add", null, "");
	}
	
	/**
	 * Ha orángután ment át rajta, akkor beállítja azt legutolsó orángutánnak
	 */
	public void setOrangutan (Orangutan o) {
		Logger.get_static_logger().enter(this, "Add", null);
		
		myO=o;
		
		Logger.get_static_logger().exit(this, "Add", null, "");
	}
}
