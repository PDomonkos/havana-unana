package animal;
import java.util.ArrayList;
import java.util.List;

import def.Game;
import def.Tester;
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
	//private int dir;
	
	/**
	 * Konstruktor
	 */
	public Orangutan() {
		grabBlock=0;
		dir=-1;
	}
	
		
	/**
	 * Orángután lép
	 */
	public void Step() {
		//nem akart lépni
		if(dir==-1) return;
		//sikertelen lépés miatt csak
		Tile t=myTile;
		
		if(grabBlock!=0) grabBlock--;
		
		Tile[] neighbours=myTile.GetNeighbours();
		Tile t2=neighbours[dir % neighbours.length];
		t2.Accept(this);
		
		dir=0;
		
		if(t == myTile)
			Tester.WriteOutput("SIKERTELEN LÉPÉS %s", new Object[] {this});
		else
			Tester.WriteOutput("SIKERES LÉPÉS %s", new Object[] {this});
		dir=-1;
	}
	
	
	/**
	 * Orángután meghal, vége a játéknak
	 */
	public void Die() {
		
		Tester.WriteOutput("MEGHALT %s ITT: %s", new Object[] {this,myTile});
		
		if (follower != null) follower.Let();
		
		myTile.Remove();
		
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
			
			if (this.follower != null)
				p.Grab(this.follower);
			this.follower=p;
			
			Tester.WriteOutput("%s MEGFOGTA ÕT: %s", new Object[] {this,p});
			
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
		grabBlock=2;
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
		follower.SetLeader(null);		//itt van változtatás
		follower=null;
		
		Tester.WriteOutput("%s KIMENT", new Object[] {this});
		
	}

	/**
	 * Pontot az az orángutánnak
	 */
	public void AddPoint() {
		Game.AddPoint(this);
		
		Tester.WriteOutput("%s PONTOT KAPOTT", new Object[] {this});
	}
	
	/**
	 * Irány növelése
	 */
	public void IncDir() {
		dir++;
		if (dir==myTile.GetNeighbours().length)
			dir=0;
	}
	
//	NEVEM: <ÁLLAT NEVE>
//	TÍPUSOM: <ÁLLAT TÍPUSA>
//	CSEMPE, AHOL ÁLLOK: [<CSEMPE NEVE>]
//	KÖVETÕM: <ÁLLAT NEVE> (null ha nincs)
//	MÉG ENNYI KÖRIG NEM FOGHATOK PANDÁT: 
//	<SZÁM> - (csak orángután esetén)
//	pl. “MÉG ENNYI KÖRIG NEM FOGHATOK PANDÁT: 2”
//	LÉPHETEK: <IGEN/NEM> - (csak a pandák esetén)
//	VEZETÕM: <ÁLLAT NEVE> - (csak a pandák esetén) (null ha nincs)	
	public void ListAttributes() {
		/*Tester.WriteOutput(
				"NEVEM: %s\nTÍPUSOM: HungryPanda\nCSEMPE, AHOL ÁLLOK: %s\nKÖVETÕM:%s\nMÉG ENNYI KÖRIG NEM FOGHATOK PANDÁT:" + grabBlock, 
				new Object[] {this, myTile, follower});*/

			String base = new String("NEVEM: %s\n" + "TÍPUSOM: Orangutan\n" + "CSEMPE, AHOL ÁLLOK: [%s]\n");
			List<Object> obj = new ArrayList<Object>();
			obj.add(this);
			obj.add(myTile);

			if (follower == null)
				base += new String("KÖVETÕM: null\n");
			else {
				base += new String("KÖVETÕM: %s\n");
				obj.add(follower);
			}
			
			base+= new String("MÉG ENNYI KÖRIG NEM FOGHATOK PANDÁT: " + grabBlock);

			Object[] objArr = new Object[obj.size()];
			objArr = obj.toArray();
			Tester.WriteOutput(base, objArr);
	}	
}
