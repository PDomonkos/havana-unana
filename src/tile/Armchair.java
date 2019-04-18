package tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
import animal.Panda;
import def.Tester;
/**
 * Fotelt reprezent�l� oszt�ly
 *
 */
public class Armchair extends Tile {
	/**
	 * Sz�ml�l�
	 */
	int count;
	
	/**
	 * konstruktor: sz�ml�l� inicializ�l�sa
	 */
	public Armchair() {
		count=2;
	}
	
	/**
	 * L�p�s: 
	 * 
	 * Ha nincs benne �llat, jelez a szomsz�dainak, hogy �res fotel van a szomsz�djukban
	 * K�l�nben cs�kkenti a sz�ml�l�t, ha az nulla lett elengedi a benne �l� �llatot
	 */
	public void Step() {
		
		if(myAnimal==null) {
			if (!Tester.isRandom) {
				for(Tile n: neighbours) {
					Animal a=n.GetAnimal();
					if (a!= null)
						a.TakeASeat(this);		
				}
			}
			else {
				Random rand = new Random();
				int r=rand.nextInt( 10 );
				if(r>6) {
					for(Tile n: neighbours) {
						Animal a=n.GetAnimal();
						if (a!= null)
							a.TakeASeat(this);		
					}
				}
			}
		}else {
			count--;
			if (count==0) {
				((Panda)myAnimal).EnableSteps();
				count=2;
			}
		}
		
		
	}
	
	/**
	 * Nem lehet r�l�pni	
	 */
	public void Accept(Animal a) {

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: Armchair\n" + 
				"SZOMSZ�DAIM: ");
		List<Object> obj = new ArrayList<Object>();
		obj.add(this);
		for(int i=0; i<neighbours.length; i++) {
			obj.add(neighbours[i]);
			if(i==neighbours.length-1)
				base+= i+ " - %s\n";
			else
				base+= i+ " - %s, ";
		}
		
		if(myAnimal==null)
			base+= new String("A RAJTAM �LL� �LLAT: null\n");
		else {
			base+= new String("A RAJTAM �LL� �LLAT: %s\n");
			obj.add(myAnimal);
		}
		
		base+= new String("M�G ENNYI K�RIG PIHENSZ " + count + "\n");
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
