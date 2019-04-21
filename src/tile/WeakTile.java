package tile;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;
import def.Tester;

/**
 * T�r�keny csempe
 *
 */
public class WeakTile extends Tile {
	/**
	 * csempe �lettartama
	 */
	private int count;

	/**
	 * Konstruktor, mindig 20 �lete van
	 */
	public WeakTile() {
		this.count = 20;
	}

	/**
	 * sz�ml�l� cs�kkent�se
	 */
	private void DecreaseCount() {

		count--;

	}

	/**
	 * �llat elhelyez�sekor cs�kkenti az �lettartamot, ha elt�rik, az �llat leesik
	 * 
	 * @param �rkez� �llat
	 */
	public void Add(Animal a) {

		a.SetTile(this);
		myAnimal = a;

		// majd �t�rjuk die a decreasebe legyen
		DecreaseCount();
		if (count == 0)
			a.Die();

	}

	// Be kell tudni allitani, hogy mennyi az elete
	public void set_count(int cnt) {

		this.count = cnt;

		Tester.WriteOutput("A %s T�R�S�IG M�G ENNYI VAN H�TRA: " + count, new Object[] { this });

	}

	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + "T�PUSOM: WeakTile\n" + "SZOMSZ�DAIM: ");
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
			base += new String("A RAJTAM �LL� �LLAT: null\n");
		else {
			base += new String("A RAJTAM �LL� �LLAT: %s\n");
			obj.add(myAnimal);
		}

		Object[] objArr = new Object[obj.size()];
		objArr = obj.toArray();

		base += new String("T�R�SIG M�G ENNYI VAN H�TRA: " + count);
		Tester.WriteOutput(base, objArr);
	}
}
