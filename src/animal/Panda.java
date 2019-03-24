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
	 * Konstruktor, a panda alapból léphet
	 */
	public Panda() {
		canStep=true;
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
	 * Panda elengedi a mögötte lévõ panda kezét 
	 * 
	 * A mögötte lévõ pandák is elengedik egymást, felbomlik a sor, mindenki szabadon léphet tovább
	 */
	public void Let() {
		Logger.get_static_logger().enter(this, "Let", null);
		
		if (follower != null) {
			follower.Let();
			follower.EnableSteps();
		}
		
		follower=null;
		
		Logger.get_static_logger().exit(this, "Let", null, "");
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
	 * Panda nekimenne egy másik pandának
	 * 
	 * Nem történik semmi, nem léphet oda
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Panda elhagyja a pályát, pontot ad a megfelelõ orángutánnak
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).addPoint();
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
	
	/**
	 * Panda helyet cserél egy orángutánnal
	 * 
	 * @param t orángután csempéje
	 * @param o orángután
	 */
	public void Swap(Tile t, Orangutan o) {
		Logger.get_static_logger().enter(this, "Swap", null);
		
		myTile.Add(o);
		t.Add(this);
		
		Logger.get_static_logger().exit(this, "Swap", null, "");
	}
}
