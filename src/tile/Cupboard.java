package tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import animal.Animal;
import def.Tester;

/**
 * Szekr�nyt reprezent�l� oszt�ly
 *
 */
public class Cupboard extends Tile {
	/**
	 * szomsz�dos szekr�nyek
	 */
	private Cupboard[] cupboards;
	
	/**
	 * Be�ll�tja a szomsz�dos szekr�nyeit
	 */
	public void SetCupboards(Cupboard[] c) {
		
		cupboards=c;
		
	}
	
	/**
	 * �llat l�p a szekr�nybe
	 * 
	 * Ha �llat �llt rajta akkor �tk�ztet, ha nincs mozgatja egy szomsz�dra
	 * ha elkapott egy or�ngut�n egy pand�t akkor az or�ngut�n �trakja
	 */
	public void Accept(Animal a) {
		
		Animal oldAnimal=myAnimal;
		
		if(myAnimal!=null) myAnimal.HitBy(a);
		else {
			Random rand=new Random();
			//�ress�g ellen�rz�se
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
		//Or�ngut�n elkapja a pand�t esetben fut le (csak ekkor v�ltozik az �llat)
		if(myAnimal!=oldAnimal) {
			Random rand=new Random();
			//�ress�g ellen�rz�se itt is
			a.Move(cupboards[rand.nextInt(cupboards.length)]);
		}
		
	}
	
	public void ListAttributes() {
		String base = new String("NEVEM: %s\n" + 
				"T�PUSOM: Cupboard\n" + 
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
			base+= new String("A RAJTAM �LL� �LLAT: null");
		else {
			base+= new String("A RAJTAM �LL� �LLAT: %s");
			obj.add(myAnimal);
		}
		
		Object[] objArr=new Object[obj.size()];
		objArr=obj.toArray();
		Tester.WriteOutput(base, objArr);
	}
	
}
