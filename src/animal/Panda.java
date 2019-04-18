package animal;
import java.util.Random;

import def.Main;
import def.Tester;
import tile.Tile;
import tile.Entry;
import def.Game;

/**
 * Panda osztály
 *
 * Játékosok álltal nem irányítható állat
 */
public class Panda extends Animal {
	/**
	 * Meghatározza, hogy a panda léphet e magától
	 */
	protected boolean canStep;
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
		
		myTile.Remove();
		myTile=null;
		this.Let();
		
		//láthatóság
		Game.RemoveSteppable(this);
		
	}
	
	/**
	 * Állat elengedi a mögötte lévõ panda kezét 
	 * 
	 * Az elõtte lévõ panda elengedi, a mögötte lévõ pandák is elengedik egymást, felbomlik a sor, mindenki szabadon léphet tovább
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
	 * Panda véletlenszerûen lép egy szomszédos mezõre, ha léphet
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
	 * Engedi lépni a pandát
	 */
	public void EnableSteps() {
		
		canStep=true;
		
	}
	
	/**
	 * Panda nem léphet magától
	 */
	public void DisableSteps() {
		
		canStep=false;
		
	}
	
	/**
	 * Egy másik állat nekiment a pandának, aki visszajelez, hogy ütközött egy pandával
	 */
	public void HitBy(Animal a) {
		
		a.CollideWith(this);
		
	}
	
	/**
	 * Panda elhagyja a pályát, pontot ad a megfelelõ orángutánnak, és nullra állítja a referenciáit
	 */
	public void Exit() {

		if (leader==null) {
			((Entry)myTile).AddPoint();
			follower=null;
			leader=null;
			myTile.Remove();
			myTile=null;
			//léthatóség
			Game.RemoveSteppable(this);
		}
				
	}
}
