package animal;
import def.Game;
import tile.Entry;
import tile.Tile;

/**
 * Orángután osztály
 * 
 * Játékosok által irányított állat 
 */
public class Orangutan extends Animal {

	/**
	 * A panda fogást blokkoló számláló
	 */
	private int grabBlock;
	
	/**
	 * A következõ lépés iránya
	 */
	private int dir;
	
	/**
	 * Konstruktor
	 */
	public Orangutan() {
		grabBlock=0;
		dir=0;
	}
	
		
	/**
	 * Orángután lép
	 */
	public void Step() {
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();	
		Tile t2=neighbours[dir];
		t2.Accept(this);
		
		dir=0;
		
	}
	
	
	/**
	 * Orángután meghal, vége a játéknak
	 */
	public void Die() {

		//láthatóság
		Game.End(this);
		
	}	
	
	/**
	 * Orángután ütközik egy pandával
	 * 
	 * Felszabadítja azt, helyet cserélnek, majd a követõket beállítja
	 */
	public void CollideWith(Panda p) {
		
		if(grabBlock == 0) {
			p.Let();
			p.Swap(myTile, this);
			
			p.Grab(this.follower);
			this.follower=p;
			p.DisableSteps();
			p.SetLeader(this);
		}

	}
	
	/**
	 * Orángután ütközik egy másik orángutánnal
	 * 
	 * Felszabadítja azt, helyet cserélnek, majd a követõket beállítja
	 */
	public void CollideWith(Orangutan o) {
		
		if(follower == null && grabBlock ==0) {
			this.Grab(o.Steal());
			o.Swap(myTile, this);
		}

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
		
		a.CollideWith(this);
		
	}
	
	/**
	 * Orángután kijáraton áthaladva beállítja a bejáraton, hogy õ ment át rajta utána, és nullra állítja a followert
	 */
	public void Exit() {

		((Entry)myTile).SetOrangutan(this);
		follower=null;
		
	}

	/**
	 * Pontot az az orángutánnak
	 */
	public void AddPoint() {
		Game.AddPoint(this);
	}
	
	//egy set dir a teszt miatt
	//lehet incdir hivogatni is
	public void SetDir(int d) {
		dir=d;
	}
	
	/**
	 * Irány növelése
	 */
	public void IncDir() {
		dir++;
		if (dir==myTile.GetNeighbours().length)
			dir=0;
	}
	
	///list miatt
	public void ListAttributes() {
		
	}
}
