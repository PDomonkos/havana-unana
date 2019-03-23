package animal;
import def.Steppable;
import tile.Armchair;
import tile.Tile;
import def.Logger;

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
	 * Állat meghal
	 * 
	 * Leszármazottak definiálják
	 */
	public void Die() {}
	
	/**
	 * Állat lép
	 * 
	 * Leszármazottak definiálják
	 */
	public void Step() {}
	
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
		Logger.get_static_logger().enter(this, "SetTile", new Object[] {t});
		
		myTile=t;
		
		Logger.get_static_logger().exit(this, "SetTile", new Object[] {t}, "");
	}
	
	/**
	 * Állat a megadott csempére mozog, húzza magával a követõit
	 * 
	 * @param t a csempe amire lép
	 */
	public void Move(Tile t) {
		Logger.get_static_logger().enter(this, "Move", new Object[] {t});
		
		myTile.Remove();
		if (follower != null)
			follower.Move(myTile); 
		t.Add(this);
		
		Logger.get_static_logger().exit(this, "Move", new Object[] {t}, "");
	}
	
	/**
	 * Megadott pandát elkezd húzni
	 * 
	 * @param p a húzott panda
	 */
	public void Grab(Panda p) {
		Logger.get_static_logger().enter(this, "Grab", new Object[] {p});
		
		this.follower = p;
		p.DisableSteps();
		
		Logger.get_static_logger().exit(this, "Grab", new Object[] {p}, "");
	}

//////// itt definiálni?
	public void CollideWith(Orangutan o) {}

	/**
	 * Állat ütközik egy pandával
	 * 
	 * Leszármazottak definiálják
	 * 
	 * @param p a panda
	 */
	public void CollideWith(Panda p) {}

/////// itt is ki lehetne fejteni
	public void HitBy(Animal a) {}
	
	/**
	 * Állat reakciója egy adott fotel közelségére, alapértelmezetten semmi
	 * 
	 * @param a adott fotel
	 */
	public void TakeASeat(Armchair a) {}
}
