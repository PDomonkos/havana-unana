package animal;
import java.util.Random;

import def.Logger;
import tile.Tile;
import tile.Entry;

/**
 * Panda oszt�ly
 *
 * J�t�kosok �lltal nem ir�ny�that� �llat
 */
public class Panda extends Animal {
	/**
	 * Meghat�rozza, hogy a panda l�phet e mag�t�l
	 */
	private boolean canStep;
	
	/**
	 * Konstruktor, a panda alapb�l l�phet
	 */
	public Panda() {
		canStep=true;
	}
	
	/**
	 * Panda lezuhan �s meghal
	 * 
	 * Elt�vol�tja mag�t a csemp�r�l, elengedi a k�vet�it
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);
		
		myTile.Remove();
		this.Let();
		
		Logger.get_static_logger().exit(this, "Die", null, "");
	}
	
	/**
	 * Panda v�letlenszer�en l�p egy szomsz�dos mez�re, ha l�phet
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
	 * Panda elengedi a m�g�tte l�v� panda kez�t 
	 * 
	 * A m�g�tte l�v� pand�k is elengedik egym�st, felbomlik a sor, mindenki szabadon l�phet tov�bb
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
	 * Engedi l�pni a pand�t
	 */
	public void EnableSteps() {
		Logger.get_static_logger().enter(this, "EnableSteps", null);
		
		canStep=true;
		
		Logger.get_static_logger().exit(this, "EnableSteps", null, "");
	}
	
	/**
	 * Panda nem l�phet mag�t�l
	 */
	public void DisableSteps() {
		Logger.get_static_logger().enter(this, "DisableSteps", null);
		
		canStep=false;
		
		Logger.get_static_logger().exit(this, "DisableSteps", null, "");
	}
	
	/**
	 * Egy m�sik �llat nekiment a pand�nak, aki visszajelez, hogy �tk�z�tt egy pand�val
	 */
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		
		a.CollideWith(this);
		
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
		
	/**
	 * Panda nekimenne egy m�sik pand�nak
	 * 
	 * Nem t�rt�nik semmi, nem l�phet oda
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
	
	/**
	 * Panda elhagyja a p�ly�t, pontot ad a megfelel� or�ngut�nnak
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).addPoint();
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
	
	/**
	 * Panda helyet cser�l egy or�ngut�nnal
	 * 
	 * @param t or�ngut�n csemp�je
	 * @param o or�ngut�n
	 */
	public void Swap(Tile t, Orangutan o) {
		Logger.get_static_logger().enter(this, "Swap", null);
		
		myTile.Add(o);
		t.Add(this);
		
		Logger.get_static_logger().exit(this, "Swap", null, "");
	}
}
