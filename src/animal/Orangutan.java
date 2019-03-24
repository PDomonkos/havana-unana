package animal;
import def.Game;
import def.Logger;
import tile.Entry;
import tile.Tile;

/**
 * Orángután osztály
 * 
 * Játékosok által irányított állat 
 */
public class Orangutan extends Animal {
	/**
	 * Játékot reprezentáló osztály
	 */
	static Game game;
	
	/**
	 * Adott játék beállítása
	 * 
	 * @param g játék
	 */
	public static void setGame(Game g) {

		game=g;
		
	}
		
	/**
	 * Orángután lép
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		Tile[] neighbours=myTile.GetNeighbours();	
		//késõbb megcsináljuk, hogy a választottra lépjen
		Tile t2=neighbours[0];
		t2.Accept(this);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	

	/**
	 * Orángutánnak nekimenve nem történik semmi, nem léphetnek rá
	 */
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Orángután meghal, vége a játéknak
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);

		game.end(this);
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}	
	
	/**
	 * Orángután ütközik egy pandával
	 * 
	 * Felszabadítja azt, helyet cserélnek, majd a követõket beállítja
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		
		p.Let();
		p.Swap(myTile, this);
		
		p.Grab(this.follower);
		this.follower=p;
		p.DisableSteps();

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Orángután kijáraton áthaladva beállítja a bejáraton, hogy õ ment át rajta utána
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).setOrangutan(this);
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
}
