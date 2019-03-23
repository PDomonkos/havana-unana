package animal;
import def.Logger;
import tile.Tile;

/**
 * Panda osztály
 *
 */
public class Panda extends Animal {
	/**
	 * 
	 */
	private boolean canStep;
	
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);
		
		myTile.Remove();
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}
	
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		Tile[] neighbours=myTile.GetNeighbours();
		Tile t2=neighbours[0];
		t2.Accept(this); //random válaszottam ki a 0.-t
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
	/**
	 * Panda adott csempére mozgatása
	 * 
	 * @param Tile a cél csempe
	 */
	public void Follow(Object Tile) {
		Logger.get_static_logger().enter(this, "Follow", new Object[] {Tile});
		Logger.get_static_logger().exit(this, "Follow", null, "");
	}
	
	public void Let() {
		Logger.get_static_logger().enter(this, "Let", null);
		
		if (follower != null)
			follower.Let();
		follower=null;
		
		Logger.get_static_logger().exit(this, "Let", null, "");
	}
	
	public void EnableSteps() {
		Logger.get_static_logger().enter(this, "EnableSteps", null);
		Logger.get_static_logger().exit(this, "EnableSteps", null, "");
	}
	
	public void DisableSteps() {
		Logger.get_static_logger().enter(this, "DisableSteps", null);
		Logger.get_static_logger().exit(this, "DisableSteps", null, "");
	}
	
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		a.CollideWith(this);
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	public void CollideWith(Orangutan o) {	
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {o});
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {o}, "");
	}
	
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
}
