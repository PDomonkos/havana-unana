package animal;
import java.util.Random;

import def.Main;
import def.Tester;
import tile.Tile;
import tile.Entry;
import def.Game;

/**
 * Panda oszt�ly
 *
 * J�t�kosok �lltal nem ir�ny�that� �llat
 */
public class Panda extends Animal {
	/**
	 * Meghat�rozza, hogy a panda l�phet e mag�t�l
	 */
	protected boolean canStep;
	/**
	 * A pand�t h�z� �llat
	 */
	protected Animal leader; 
	
	/**
	 * Be�ll�tja a pand�t h�z� �llatot
	 */
	public void SetLeader(Animal a) {
		leader=a;
	}
	
	/**
	 * Konstruktor, a panda alapb�l l�phet
	 */
	public Panda() {
		canStep=true;
		leader=null;
	}
	
	/**
	 * Panda lezuhan �s meghal
	 * 
	 * Elt�vol�tja mag�t a csemp�r�l, elengedi a k�vet�it
	 */
	public void Die() {
		
		myTile.Remove();
		myTile=null;
		this.Let();
		
		//l�that�s�g
		Game.RemoveSteppable(this);
		
	}
	
	/**
	 * �llat elengedi a m�g�tte l�v� panda kez�t 
	 * 
	 * Az el�tte l�v� panda elengedi, a m�g�tte l�v� pand�k is elengedik egym�st, felbomlik a sor, mindenki szabadon l�phet tov�bb
	 */
	public void Let() {
		
		if (leader!=null) {
			leader.ResetFollower();
		}
		
		leader=null;
		this.EnableSteps();
		
		if (follower != null) {
			follower.Let();
		}
		
	}
	
	/**
	 * Panda v�letlenszer�en l�p egy szomsz�dos mez�re, ha l�phet
	 */
	public void Step() {
		
		if (canStep){
			Tile[] neighbours=myTile.GetNeighbours();
			Random rand = new Random();
			Tile t2=neighbours[rand.nextInt( neighbours.length )];
			t2.Accept(this);
		}	
		
	}
	

	/**
	 * Engedi l�pni a pand�t
	 */
	public void EnableSteps() {
		
		canStep=true;
		
	}
	
	/**
	 * Panda nem l�phet mag�t�l
	 */
	public void DisableSteps() {
		
		canStep=false;
		
	}
	
	/**
	 * Egy m�sik �llat nekiment a pand�nak, aki visszajelez, hogy �tk�z�tt egy pand�val
	 */
	public void HitBy(Animal a) {
		
		a.CollideWith(this);
		
	}
	
	/**
	 * Panda elhagyja a p�ly�t, pontot ad a megfelel� or�ngut�nnak, �s nullra �ll�tja a referenci�it
	 */
	public void Exit() {

		if (leader==null) {
			((Entry)myTile).AddPoint();
			follower=null;
			leader=null;
			myTile.Remove();
			myTile=null;
			//l�that�s�g
			Game.RemoveSteppable(this);
		}
				
	}
}
