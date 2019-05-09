package tile;

import java.util.ArrayList;
import java.util.List;

import animal.Animal;

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
	}

	public int GetCount() {
		return count;
	}	
}
