package animal;
import def.Steppable;
import tile.Armchair;
import tile.Tile;
import def.Logger;

/**
 * �llatokat reprezent�l� absztakt, l�ptethet� �soszt�ly
 *
 */
public abstract class Animal implements Steppable {
	/**
	 * Csempe amin az �llat �ll
	 */
	protected Tile myTile;
	/**
	 * �llat �ltal h�zott panda
	 */
	protected Panda follower;
	
	/**
	 * Konstruktor
	 * 
	 * Adattagokat nullra �ll�tja
	 */
	public Animal() {
		myTile=null;
		follower=null;
	}
		
	/**
	 * �llat elengedi a m�g�tte l�v� panda kez�t 
	 * 
	 * A m�g�tte l�v� pand�k is elengedik egym�st, felbomlik a sor, mindenki szabadon l�phet tov�bb
	 */
	public void Let() {
		Logger.get_static_logger().enter(this, "Let", null);
		
		if (follower != null) {
			follower.Let();
			follower.EnableSteps();
		}
		
		follower=null;
		
		Logger.get_static_logger().exit(this, "Let", null, "");
	}
	
	/**
	 * �llat meghal
	 * 
	 * Lesz�rmazottak defini�lj�k
	 */
	public void Die() {}
	
	/**
	 * �llat reakci�ja a csilingel�sre, alapvet�en semmi
	 */
	public void ReactToJingle() {}
	
	/**
	 * �llat reakci�ja a s�pol�sra, alapvet�en semmi
	 */
	public void ReactToBeep() {}
	
	/**
	 * �llat elhagyja a p�ly�t
	 * 
	 * Lesz�rmazottak defini�lj�k
	 */
	public void Exit() {}
	
	/**
	 * A param�terben kapott csemp�t be�ll�tja csemp�j�nek
	 * 
	 * @param t megadott csempe
	 */
	public void SetTile(Tile t) {
		Logger.get_static_logger().enter(this, "SetTile", new Object[] {t});
		
		myTile=t;
		
		Logger.get_static_logger().exit(this, "SetTile", new Object[] {t}, "");
	}
	
	/**
	 * �llat a megadott csemp�re mozog, h�zza mag�val a k�vet�it
	 * 
	 * @param t a csempe amire l�p
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
	 * �llat helyet cser�l egy or�ngut�nnal
	 * 
	 * @param t or�ngut�n csemp�je
	 * @param o or�ngut�n
	 */
	public void Swap(Tile t, Orangutan o) {
		Logger.get_static_logger().enter(this, "Swap", null);
		
		myTile.Add(o);
		t.Add(this);
		
		Logger.get_static_logger().exit(this, "Swap", null, "");
	}
	
	/**
	 * Megadott pand�t elkezd h�zni
	 * 
	 * @param p a h�zott panda
	 */
	public void Grab(Panda p) {
		Logger.get_static_logger().enter(this, "Grab", new Object[] {p});
		
		this.follower = p;
		p.DisableSteps();
		
		Logger.get_static_logger().exit(this, "Grab", new Object[] {p}, "");
	}
	
	/**
	 * �llat �tk�zik egy pand�val
	 * 
	 * Lesz�rmazottak defini�lj�k
	 * 
	 * @param p a panda
	 */
	public void CollideWith(Panda p) {}

	/**
	 * �llat �tk�zik egy or�ngut�nal
	 * 
	 * Lesz�rmazottak defini�lj�k
	 * 
	 * @param o az or�ngut�n
	 */
	public void CollideWith(Orangutan o) {}

	
	/**
	 * �llatnak nekimenve az jelez, hogy �tk�ztek vele
	 */
	public void HitBy(Animal a) {
	}
	
	/**
	 * �llat reakci�ja egy adott fotel k�zels�g�re, alap�rtelmezetten semmi
	 * 
	 * @param a adott fotel
	 */
	public void TakeASeat(Armchair a) {}
}
