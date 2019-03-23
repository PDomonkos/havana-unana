package animal;
import def.Logger;
import tile.Tile;

/**
 * Orángután osztály
 * 
 * Játékosok által irányított állat 
 */
public class Orangutan extends Animal {
	
	/**
	 * Orángután lép
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		Tile[] neighbours=myTile.GetNeighbours();	
/////////////////////////////////////////////
		//nem kéne átadni hova lép?
		Tile t2=neighbours[0];
		t2.Accept(this);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
//////////////////////////////
	//õsbe lehetne?
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		a.CollideWith(this);
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Orángután meghal, vége a játéknak
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);
/////////////////////////////
		//gamen hívhatan egy endet
		Logger.get_static_logger().exit(this, "Die", null, "");
	}
	

///////////////////////
	//szintén lehetne õsben
/////// logger sincs
	public void CollideWith(Orangutan o) {	
	}
	
	/**
	 * Orángután ütközik egy pandával
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
////////////////////////////		
		myTile.Add(p);//így nem hívódik a remove, ezért let és move kellene (let amúgy se ártana)
		
		p.Grab(this.follower);
		this.follower=p;
		p.DisableSteps();
/////////////////////////////////////		
		//ide kéne valami, hogy t1-et addoljuk
		//szerintem csak accept tudná hívni a hitby után de akkor mégis cscak kéne az a bool visszatérés
		
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
}
