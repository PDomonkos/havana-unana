package animal;
import java.util.ArrayList;
import java.util.List;

import def.Game;
import tile.Entry;
import tile.Tile;

/**
 * Or�ngut�n oszt�ly
 * 
 * J�t�kosok �ltal ir�ny�tott �llat 
 */
public class Orangutan extends Animal {

	/**
	 * A panda fog�st blokkol� sz�ml�l�
	 */
	private int grabBlock;
	
	/**
	 * A k�vetkez� l�p�s ir�nya
	 */
	//private int dir;
	
	/**
	 * Konstruktor
	 */
	public Orangutan() {
		grabBlock=0;
		dir=-1;
	}
	
		
	/**
	 * Or�ngut�n l�p
	 */
	public void Step() {
		//nem akart l�pni
		if(dir==-1) return;
		//sikertelen l�p�s miatt csak
		Tile t=myTile;
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();
		Tile t2=neighbours[dir % neighbours.length];
		t2.Accept(this);
		
		dir=-1;
	}
	
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {
		Release();
		
		myTile.Remove();
		
		Game.End(this);
		
	}	
	
	/**
	 * Or�ngut�n �tk�zik egy pand�val
	 * 
	 * Felszabad�tja azt, helyet cser�lnek, majd a k�vet�ket be�ll�tja
	 */
	public void CollideWith(Panda p) {
		
		if(grabBlock == 0) {
			p.Let();
			p.Swap(myTile, this);
			
			if (this.follower != null)
				p.Grab(this.follower);
			this.follower=p;
			
			p.DisableSteps();
			p.SetLeader(this);
		}

	}
	
	/**
	 * Or�ngut�n �tk�zik egy m�sik or�ngut�nnal
	 * 
	 * Felszabad�tja azt, helyet cser�lnek, majd a k�vet�ket be�ll�tja
	 */
	public void CollideWith(Orangutan o) {
		
		if(follower == null && grabBlock ==0) {
			this.Grab(o.Steal());
			o.Swap(myTile, this);
		}

	}
	
	/**
	 * Ellopj�k t�le a k�vet�j�t
	 */
	public Panda Steal() {
		Panda ret=follower;
		follower=null;
		grabBlock=2;
		return ret;
	} 
	
	/**
	 * �nk�nt engedi el a h�zott pand�t
	 */
	public void Release() {
		if (follower!=null)
			follower.Let();
	}
	
	/**
	 * Egy m�sik �llat nekiment a pand�nak, aki visszajelez, hogy �tk�z�tt egy pand�val
	 */
	public void HitBy(Animal a) {
		
		a.CollideWith(this);
		
	}
	
	/**
	 * Or�ngut�n kij�raton �thaladva be�ll�tja a bej�raton, hogy � ment �t rajta ut�na, �s nullra �ll�tja a followert
	 */
	public void Exit() {

		((Entry)myTile).SetOrangutan(this); 
		follower=null;
		
	}

	/**
	 * Pontot az az or�ngut�nnak
	 */
	public void AddPoint() {
		Game.AddPoint(this);
	}
	
	/**
	 * Ir�ny n�vel�se
	 */
	public void IncDir() {
		dir++;
		if (dir==myTile.GetNeighbours().length)
			dir=0;
	}
	
	public Tile getMarkedTile() {
		if (this.dir == -1) return null;
		Tile[] neighbours=myTile.GetNeighbours();
		Tile t2=neighbours[dir % neighbours.length];
		return t2;
	}
}
