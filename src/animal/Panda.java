package animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import def.Main;
import def.Tester;
import tile.Tile;
import tile.Entry;
import def.Game;
import def.Tester;

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
		dir=-1;
	}
	
	/**
	 * Panda lezuhan és meghal
	 * 
	 * Eltávolítja magát a csempéről, elengedi a követőit
	 */
	public void Die() {
		
		Tester.WriteOutput("MEGHALT %s ITT: %s", new Object[] {this,myTile});
		
		myTile.Remove();
		myTile=null;
		this.Let();
		
		//láthatóság
		Game.RemoveSteppable(this);	
		
	}
	
	/**
	 * Állat elengedi a mögötte lévő panda kezét 
	 * 
	 * Az előtte lévő panda elengedi, a mögötte lévő pandák is elengedik egymást, felbomlik a sor, mindenki szabadon léphet tovább
	 */
	public void Let() {
		
		if (leader!=null) {
			leader.ResetFollower();
			Tester.WriteOutput("%s ELENGEDTE ÕT: %s", new Object[] {leader, this});
		}
		
		leader=null;
		this.EnableSteps();
		
		if (follower != null) {
			//Tester.WriteOutput("%s ELENGEDTE ÕT: %s", new Object[] {this,follower});
			follower.Let();
			
		}
		
	}
	
	/**
	 * Panda véletlenszerűen lép egy szomszédos mezőre, ha léphet
	 */
	public void Step() {
		if(canStep)
		{
			//sikertelen lépés miatt csak
			Tile t=myTile;
			
			if (Tester.isRandom){
				Tile[] neighbours=myTile.GetNeighbours();
				Random rand = new Random();
				Tile t2=neighbours[rand.nextInt( neighbours.length )];
				t2.Accept(this);
			}
			if(dir==-1) return;
			else if (!Tester.isRandom) {
				Tile[] neighbours=myTile.GetNeighbours();	
				Tile t2=neighbours[dir];
				t2.Accept(this);			
				dir=0;
			}
			if(t == myTile)
				Tester.WriteOutput("SIKERTELEN LÉPÉS %s", new Object[] {this});
			else
				Tester.WriteOutput("SIKERES LÉPÉS %s", new Object[] {this});
		}
		dir=-1;
		
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
	 * Panda elhagyja a pályát, pontot ad a megfelelő orángutánnak, és nullra állítja a referenciáit
	 */
	public void Exit() {

		if (leader==null) {
			((Entry)myTile).AddPoint();
			follower=null;
			leader=null;
			myTile.Remove();
			myTile=null;

			Game.RemoveSteppable(this);
				
		}
		
		Tester.WriteOutput("%s KIMENT", new Object[] {this});
				
	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "TÍPUSOM: Panda\n" + "CSEMPE, AHOL ÁLLOK: [%s]\n");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		obj.add(myTile);

		if (follower == null)
			base += new String("KÖVETŐM: null\n");
		
		else {
			base += new String("KÖVETŐM: %s\n");
			obj.add(follower);
		}
		
		if(canStep)
			base +=new String("LÉPHETEK: IGEN\n");
		else
			base +=new String("LÉPHETEK: NEM\n");
		
		if (leader == null)
			base += new String("VEZETŐM: null");
		else {
			base += new String("VEZETŐM: %s");
			obj.add(leader);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();
		Tester.WriteOutput(base, objArr);
	}	
}
