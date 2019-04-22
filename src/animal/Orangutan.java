package animal;
import java.util.ArrayList;
import java.util.List;

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
		
		dir=0;
		
		if(t == myTile)
			Tester.WriteOutput("SIKERTELEN L�P�S %s", new Object[] {this});
		else
			Tester.WriteOutput("SIKERES L�P�S %s", new Object[] {this});
		dir=-1;
	}
	
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {
		
		Tester.WriteOutput("MEGHALT %s ITT: %s", new Object[] {this,myTile});
		
		if (follower != null) follower.Let();
		
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
			
			Tester.WriteOutput("%s MEGFOGTA �T: %s", new Object[] {this,p});
			
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
		follower.SetLeader(null);		//itt van v�ltoztat�s
		follower=null;
		
		Tester.WriteOutput("%s KIMENT", new Object[] {this});
		
	}

	/**
	 * Pontot az az or�ngut�nnak
	 */
	public void AddPoint() {
		Game.AddPoint(this);
		
		Tester.WriteOutput("%s PONTOT KAPOTT", new Object[] {this});
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
		/*Tester.WriteOutput(
				"NEVEM: %s\nT�PUSOM: HungryPanda\nCSEMPE, AHOL �LLOK: %s\nK�VET�M:%s\nM�G ENNYI K�RIG NEM FOGHATOK PAND�T:" + grabBlock, 
				new Object[] {this, myTile, follower});*/

			String base = new String("NEVEM: %s\n" + "T�PUSOM: Orangutan\n" + "CSEMPE, AHOL �LLOK: [%s]\n");
			List<Object> obj = new ArrayList<Object>();
			obj.add(this);
			obj.add(myTile);

			if (follower == null)
				base += new String("K�VET�M: null\n");
			else {
				base += new String("K�VET�M: %s\n");
				obj.add(follower);
			}
			
			base+= new String("M�G ENNYI K�RIG NEM FOGHATOK PAND�T: " + grabBlock);

			Object[] objArr = new Object[obj.size()];
			objArr = obj.toArray();
			Tester.WriteOutput(base, objArr);
	}	
}
