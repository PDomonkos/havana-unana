package animal;
import def.Game;
import def.Tester;
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
		dir=0;
	}
	
		
	/**
	 * Or�ngut�n l�p
	 */
	public void Step() {
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();	
		Tile t2=neighbours[dir];
		t2.Accept(this);
		
		dir=0;
		
	}
	
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {

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
		grabBlock=3;
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
	
//	NEVEM: <�LLAT NEVE>
//	T�PUSOM: <�LLAT T�PUSA>
//	CSEMPE, AHOL �LLOK: [<CSEMPE NEVE>]
//	K�VET�M: <�LLAT NEVE> (null ha nincs)
//	M�G ENNYI K�RIG NEM FOGHATOK PAND�T: 
//	<SZ�M> - (csak or�ngut�n eset�n)
//	pl. �M�G ENNYI K�RIG NEM FOGHATOK PAND�T: 2�
//	L�PHETEK: <IGEN/NEM> - (csak a pand�k eset�n)
//	VEZET�M: <�LLAT NEVE> - (csak a pand�k eset�n) (null ha nincs)	
	public void ListAttributes() {
		Tester.WriteOutput(
				"NEVEM: %s\nT�PUSOM: HungryPanda\nCSEMPE, AHOL �LLOK: %s\nK�VET�M:%s\nM�G ENNYI K�RIG NEM FOGHATOK PAND�T:" + grabBlock, 
				new Object[] {this, myTile, follower});
	}	
}
