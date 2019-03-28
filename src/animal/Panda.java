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
	 * A pand�t h�z� �llat
	 */
	protected Animal leader; 
	
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
	 * Panda elhagyja a p�ly�t, pontot ad a megfelel� or�ngut�nnak
	 */
	public void Exit() {
		Logger.get_static_logger().enter(this, "Exit", null);

		((Entry)myTile).AddPoint();
		
		Logger.get_static_logger().exit(this, "Exit", null, "");
	}
	
}
