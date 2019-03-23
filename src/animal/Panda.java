package animal;
import def.Logger;
import tile.Tile;
import java.util.Random;

/**
 * Panda osztály
 *
 */
public class Panda extends Animal {
	/**
	 * Meghatározza, hogy a panda léphet e magától
	 */
	private boolean canStep;
	
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
	

	/*public void Follow(Object Tile) {
		Logger.get_static_logger().enter(this, "Follow", new Object[] {Tile});
		Logger.get_static_logger().exit(this, "Follow", null, "");
	}*/
	
	/**
	 * Panda elengedi a mögötte lévõ panda kezét 
	 * 
	 * A mögötte lévõ pandák is elengedik egymást, felbomlik a sor
	 */
	public void Let() {
		Logger.get_static_logger().enter(this, "Let", null);
		
		if (follower != null)
			follower.Let();
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
	 * Egy állat nekiment a pandának, aki visszajelez, hogy ütközött egy pandával
	 */
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		a.CollideWith(this);
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Panda nekimenne egy orángutánnak
	 * 
	 * Nem történik semmi, nem léphet oda
	 */
	public void CollideWith(Orangutan o) {	
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {o});
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {o}, "");
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
	 * Panda elhagyja a pályát
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);
///////////////////////////////////////////////////
		//ide kéne hogy az orángutánnak ad pontot, meg tárolni hogy ki a húzó
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
}
