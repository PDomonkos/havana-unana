package tile;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import def.Tester;

/**
 * Törékeny csempe
 *
 */
public class WeakTile extends Tile {
	/**
	 * csempe élettartama
	 */
	private int count;

	/**
	 * Konstruktor, mindig 20 élete van
	 */
	public WeakTile() {
		this.count = 20;
	}

	/**
	 * számláló csökkentése
	 */
	private void DecreaseCount() {

		count--;

	}

	/**
	 * Állat elhelyezésekor csökkenti az élettartamot, ha eltörik, az állat leesik
	 * 
	 * @param érkezõ állat
	 */
	public void Add(Animal a) {

		a.SetTile(this);
		myAnimal = a;

		// majd átírjuk die a decreasebe legyen
		DecreaseCount();
		if (count == 0)
			a.Die();

	}

	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) {

		this.count = cnt;

		Tester.WriteOutput("A %s TÖRÉSÉIG MÉG ENNYI VAN HÁTRA: " + count, new Object[] { this });

	}

	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "TÍPUSOM: WeakTile\n" + "SZOMSZÉDAIM: ");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		for (int i = 0; i < neighbours.length; i++) {
			obj.add(neighbours[i]);
			if (i == neighbours.length - 1)
				base += i + " - %s\n";
			else
				base += i + " - %s, ";
		}

		if (myAnimal == null)
			base += new String("A RAJTAM ÁLLÓ ÁLLAT: null\n");
		else {
			base += new String("A RAJTAM ÁLLÓ ÁLLAT: %s\n");
			obj.add(myAnimal);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();

		base += new String("TÖRÉSIG MÉG ENNYI VAN HÁTRA: " + count);
		Tester.WriteOutput(base, objArr);
	}
}
