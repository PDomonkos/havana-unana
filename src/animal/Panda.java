package animal;
import java.util.Random;

import def.Logger;
import tile.Tile;
import tile.Entry;

/**
 * Panda osztály
 *
 * Játékosok álltal nem irányítható állat
 */
public class Panda extends Animal {
	/**
	 * Meghatározza, hogy a panda léphet e magától
	 */
	private boolean canStep;
	/**
	 * A pandát húzó állat
	 */
	protected Animal leader; 
	
	/**
	 * Beállítja a pandát húzó állatot
	 */
	public void SetLeader(Animal a) {
		leader=a;
	}
	
	/**
	 * Konstruktor, a panda alapból léphet
	 */
	public Panda() {
		canStep=true;
		leader=null;
	}
	
	/**
	 * Panda lezuhan és meghal
	 * 
	 * Eltávolítja magát a csempérõl, elengedi a követõit
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);
		
		myTile.Remove();
		this.Let();
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}
	
	/**
	 * Állat elengedi a mögötte lévõ panda kezét 
	 * 
	 * Az elõtte lévõ panda elengedi, a mögötte lévõ pandák is elengedik egymást, felbomlik a sor, mindenki szabadon léphet tovább
	 */
	public void Let() {
		Logger.get_static_logger().enter(this, "Let", null);
		
		if (leader!=null) {
			leader.ResetFollower();
		}
		
		leader=null;
		this.EnableSteps();
		
		if (follower != null) {
			follower.Let();
		}
		
		Logger.get_static_logger().exit(this, "Let", null, "");
	}
	
	/**
	 * Panda véletlenszerûen lép egy szomszédos mezõre, ha léphet
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		if (canStep){
			Tile[] neighbours=myTile.GetNeighbours();
			Random rand = new Random();
			Tile t2=neighbours[rand.nextInt( neighbours.length )];
			t2.Accept(this);
		}	
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	

	/**
	 * Engedi lépni a pandát
	 */
	public void EnableSteps() {
		Logger.get_static_logger().enter(this, "EnableSteps", null);
		
		canStep=true;
		
		Logger.get_static_logger().exit(this, "EnableSteps", null, "");
	}
	
	/**
	 * Panda nem léphet magától
	 */
	public void DisableSteps() {
		Logger.get_static_logger().enter(this, "DisableSteps", null);
		
		canStep=false;
		
		Logger.get_static_logger().exit(this, "DisableSteps", null, "");
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
	 * Panda elhagyja a pályát, pontot ad a megfelelõ orángutánnak, és nullra állítja a referenciáit
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).AddPoint();
		follower=null;
		leader=null;
		myTile.Remove();
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
	
}
