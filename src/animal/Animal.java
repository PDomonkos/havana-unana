package animal;
import def.Steppable;
import def.Tester;
import tile.Armchair;
import tile.Tile;

/**
 * Állatokat reprezentáló absztakt, léptethetõ õsosztály
 *
 */
public abstract class Animal implements Steppable {
	/**
	 * Csempe amin az állat áll
	 */
	protected Tile myTile;
	/**
	 * Állat által húzott panda
	 */
	protected Panda follower;
	
	/**
	 * Konstruktor
	 * 
	 * Adattagokat nullra állítja
	 */
	public Animal() {
		myTile=null;
		follower=null;
	}
	
	/**
	 * Null-ra állítja a follovert
	 */
	public void ResetFollower() {
		follower=null;
	}
	
	/**
	 * Állat meghal
	 * 
	 * Leszármazottak definiálják
	 */
	public void Die() {}
	
	/**
	 * Állat reakciója a csilingelésre, alapvetõen semmi
	 */
	public void ReactToJingle() {}
	
	/**
	 * Állat reakciója a sípolásra, alapvetõen semmi
	 */
	public void ReactToBeep() {}
	
	/**
	 * Állat elhagyja a pályát
	 * 
	 * Leszármazottak definiálják
	 */
	public void Exit() {}
	
	/**
	 * A paraméterben kapott csempét beállítja csempéjének
	 * 
	 * @param t megadott csempe
	 */
	public void SetTile(Tile t) {
		
		myTile=t;
		
	}
	
	/**
	 * Állat a megadott csempére mozog, húzza magával a követõit
	 * 
	 * @param t a csempe amire lép
	 */
	public void Move(Tile t) {
		
		myTile.Remove();
		if (follower != null)
			follower.Move(myTile); 
		t.Add(this);
		
	}
	
	// Teszteleshez
	// Ugyanugy mukodik mint orangutannal
	public void SetDir(int d) {
		
	}
	
	/**
	 * Állat helyet cserél egy orángutánnal
	 * 
	 * @param t orángután csempéje
	 * @param o orángután
	 */
	public void Swap(Tile t, Orangutan o) {
		
		myTile.Add(o);
		t.Add(this);
		
	}
	
	/**
	 * Megadott pandát elkezd húzni
	 * 
	 * @param p a húzott panda
	 */
	public void Grab(Panda p) {
		
		this.follower = p;
		p.DisableSteps();
		p.SetLeader(this);
		
		Tester.WriteOutput("% MEGFOGTA ÕT: %", new Object[] {this,p});
	}
	
	/**
	 * Állat ütközik egy pandával
	 * 
	 * Leszármazottak definiálják
	 * 
	 * @param p a panda
	 */
	public void CollideWith(Panda p) {}

	/**
	 * Állat ütközik egy orángutánal
	 * 
	 * Leszármazottak definiálják
	 * 
	 * @param o az orángután
	 */
	public void CollideWith(Orangutan o) {}

	
	/**
	 * Állatnak nekimenve az jelez, hogy ütköztek vele
	 */
	public void HitBy(Animal a) {
	}
	
	/**
	 * Állat reakciója egy adott fotel közelségére, alapértelmezetten semmi
	 * 
	 * @param a adott fotel
	 */
	public void TakeASeat(Armchair a) {}
}
