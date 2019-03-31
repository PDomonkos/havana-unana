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
	 * A panda fogást blokkoló számláló
	 */
	private int grabBlock;
	
	/**
	 * Konstruktor
	 */
	void Orangutan() {
		grabBlock=0;
	}
	
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
	//csakazért paraméteres, hogy lehesse nmozgatni
	public void Step(int dir) {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();	
		//késõbb megcsináljuk, hogy a választottra lépjen
		Tile t2=neighbours[0];
		t2.Accept(this);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
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
		
		if(grabBlock == 0) {
			p.Let();
			p.Swap(myTile, this);
			
			p.Grab(this.follower);
			this.follower=p;
			p.DisableSteps();
			p.SetLeader(this);
		}

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Orángután ütközik egy másik orángutánnal
	 * 
	 * Felszabadítja azt, helyet cserélnek, majd a követõket beállítja
	 */
	public void CollideWith(Orangutan o) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {o});
		
		if(follower == null && grabBlock ==0) {
			this.Grab(o.Steal());
			o.Swap(myTile, this);
		}

		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {o}, "");
	}
	
	/**
	 * Ellopják tõle a követõjét
	 */
	public Panda Steal() {
		Panda ret=follower;
		follower=null;
		grabBlock=3;
		return ret;
	} 
	
	/**
	 * Önként engedi el a húzott pandát
	 */
	public void Release() {
		if (follower!=null)
			follower.Let();
	}
	
	/**
	 * Egy másik állat nekiment a pandának, aki visszajelez, hogy ütközött egy pandával
	 */
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		a.CollideWith(this);
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Orángután kijáraton áthaladva beállítja a bejáraton, hogy õ ment át rajta utána, és nullra állítja a followert
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).setOrangutan(this);
		follower=null;
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}

	/**
	 * Pontot az az orángutánnak
	 */
	public void AddPoint() {
		game.addPoint(this);
	}
}
