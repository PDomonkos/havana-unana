package animal;
import def.Steppable;
import def.Tester;
import tile.Armchair;
import tile.Tile;

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
	 * Null-ra �ll�tja a follovert
	 */
	public void ResetFollower() {
		follower=null;
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
		
		myTile=t;
		
	}
	
	/**
	 * �llat a megadott csemp�re mozog, h�zza mag�val a k�vet�it
	 * 
	 * @param t a csempe amire l�p
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
	 * �llat helyet cser�l egy or�ngut�nnal
	 * 
	 * @param t or�ngut�n csemp�je
	 * @param o or�ngut�n
	 */
	public void Swap(Tile t, Orangutan o) {
		
		myTile.Add(o);
		t.Add(this);
		
	}
	
	/**
	 * Megadott pand�t elkezd h�zni
	 * 
	 * @param p a h�zott panda
	 */
	public void Grab(Panda p) {
		
		this.follower = p;
		p.DisableSteps();
		p.SetLeader(this);
		
		Tester.WriteOutput("% MEGFOGTA �T: %", new Object[] {this,p});
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
