package animal;
import def.Logger;
import tile.Tile;

/**
 * Or�ngut�n oszt�ly
 * 
 * J�t�kosok �ltal ir�ny�tott �llat 
 */
public class Orangutan extends Animal {
	
	/**
	 * Or�ngut�n l�p
	 */
	public void Step() {
		Logger.get_static_logger().enter(this, "Step", null);
		
		Tile[] neighbours=myTile.GetNeighbours();	
/////////////////////////////////////////////
		//nem k�ne �tadni hova l�p?
		Tile t2=neighbours[0];
		t2.Accept(this);
		
		Logger.get_static_logger().exit(this, "Step", null, "");
	}
	
//////////////////////////////
	//�sbe lehetne?
	public void HitBy(Animal a) {
		Logger.get_static_logger().enter(this, "HitBy", new Object[] {a});
		a.CollideWith(this);
		Logger.get_static_logger().exit(this, "HitBy", new Object[] {a}, "");
	}
	
	/**
	 * Or�ngut�n meghal, v�ge a j�t�knak
	 */
	public void Die() {
		Logger.get_static_logger().enter(this, "Die", null);
/////////////////////////////
		//gamen h�vhatan egy endet
		Logger.get_static_logger().exit(this, "Die", null, "");
	}
	

///////////////////////
	//szint�n lehetne �sben
	public void CollideWith(Orangutan o) {	
	}
	
	/**
	 * Or�ngut�n �tk�zik egy pand�val
	 */
	public void CollideWith(Panda p) {
		Logger.get_static_logger().enter(this, "CollideWith", new Object[] {p});
////////////////////////////		
		myTile.Add(p);//�gy nem h�v�dik a remove, ez�rt let �s move kellene (let am�gy se �rtana)
		
		p.Grab(this.follower);
		this.follower=p;
		p.DisableSteps();
/////////////////////////////////////		
		//ide k�ne valami, hogy t1-et addoljuk
		//szerintem csak accept tudn� h�vni a hitby ut�n de akkor m�gis cscak k�ne az a bool visszat�r�s
		
		Logger.get_static_logger().exit(this, "CollideWith", new Object[] {p}, "");
	}
}
