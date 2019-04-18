package tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
import animal.Panda;
import def.Tester;
/**
 * Fotelt reprezentáló osztály
 *
 */
public class Armchair extends Tile {
	/**
	 * Számláló
	 */
	int count;
	
	/**
	 * konstruktor: számláló inicializálása
	 */
	public Armchair() {
		count=2;
	}
	
	/**
	 * Lépés: 
	 * 
	 * Ha nincs benne állat, jelez a szomszédainak, hogy üres fotel van a szomszédjukban
	 * Különben csökkenti a számlálót, ha az nulla lett elengedi a benne ülõ állatot
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
	 * Nem lehet rálépni	
	 */
	public void Accept(Animal a) {

	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"TÍPUSOM: Armchair\n" + 
				"SZOMSZÉDAIM: ");
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
			base+= new String("A RAJTAM ÁLLÓ ÁLLAT: null\n");
		else {
			base+= new String("A RAJTAM ÁLLÓ ÁLLAT: %s\n");
			obj.add(myAnimal);
		}
		
		base+= new String("MÉG ENNYI KÖRIG PIHENSZ " + count + "\n");
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
}
