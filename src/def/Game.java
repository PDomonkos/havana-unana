package def;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.Timer;

import animal.Animal;
import animal.HungryPanda;
import animal.LazyPanda;
import animal.Orangutan;
import animal.Panda;
import animal.ShyPanda;
import tile.Armchair;
import tile.Cupboard;
import tile.Entry;
import tile.Exit;
import tile.SlotMachine;
import tile.Tile;
import tile.VendingMachine;
import tile.WeakTile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
/**
 * J�t�kot reprezent�l� statikus oszt�ly
 */
public class Game {

	/**
	 * L�ptethet� dolgok
	 */
	static private Steppable[] steppables;
	
	/**
	 * pontok t�rol�sa
	 */
	static private HashMap<Orangutan, Integer> points;
	
	
	 //Csak a protohoz, a dolgok �tad�sa a testernek
	private static HashMap<String, Object> testThings;
	
	/**
	 * P�lya gener�l�sa, �s kapcsolatok be�ll�t�sa
	 */
	public static void Generate(String inputFileName) {
		//azonos�t�s n�v alapj�n
		
		HashMap<String, Object> things=new HashMap<String, Object>();
		
		points = new HashMap<Orangutan, Integer>();
		
		List<Tile> tiles = new ArrayList<Tile>();
		List<Panda> pandas = new ArrayList<Panda>();
		List<Orangutan> orangutans = new ArrayList<Orangutan>();
		
		//sikeress�g vizsg�lat
		boolean successfullLoad=true;
		try {
			FileReader inputFR = new FileReader(inputFileName);
			BufferedReader inputBR=new BufferedReader(inputFR);
			
			String line;
			
			//elso �res sorig l�trehoz
			while(!(line=inputBR.readLine()).equals("*")) {
				StringTokenizer separate=new StringTokenizer(line," ");
				//neve
				String name=separate.nextToken();
				
				//megfelelo t�pus l�trehoz�sa
				switch(separate.nextToken()) {
					case "nt":  things.put(name, new Tile()); break;
					case "wt":  things.put(name, new WeakTile()); break;
					case "cb":  things.put(name, new Cupboard()); break;
					case "vm":  things.put(name, new VendingMachine()); break;
					case "sm":  things.put(name, new SlotMachine()); break;
					case "ac":  things.put(name, new Armchair()); break;
					case "en":  things.put(name, new Entry()); break;
					case "ex":  things.put(name, new Exit()); break;
					default: successfullLoad=false; break;
				}
				
				tiles.add((Tile)things.get(name));
			}
			//m�sodik �res sorig szomsz�dokat �ll�t
			while(!(line=inputBR.readLine()).equals("*")) {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,":");
				//tile akinek a szomsz�dait �ll�tjuk
				Tile actual=(Tile) things.get(separate1.nextToken());
				//, lev�laszt�sa
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szomsz�dok azonos�t�sa
				ArrayList<Tile> neighbours=new ArrayList<Tile>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Tile)things.get(separate2.nextToken()));
				}
				Tile[] tiles_tmp = new Tile[neighbours.size()];
				System.arraycopy(neighbours.toArray(), 0, tiles_tmp, 0, neighbours.size());
				actual.SetNeighbours(tiles_tmp);
			}
			//harmadik �res sorig szekr�nyek kapcsolatai
			while(!(line=inputBR.readLine()).equals("*")) {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Cupboard actual=(Cupboard) things.get(separate1.nextToken());
				//, lev�laszt�sa
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szekr�nykapcsolatok azonos�t�sa
				ArrayList<Cupboard> neighbours=new ArrayList<Cupboard>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Cupboard)things.get(separate2.nextToken()));
				}
				
				Cupboard[] cb_tmp = new Cupboard[neighbours.size()];
				System.arraycopy(neighbours.toArray(), 0, cb_tmp, 0, neighbours.size());
				//actual.SetNeighbours(cb_tmp); Nem a szomsz�dokat kell �ll�tani, hanem a szekr�nyszomsz�dot
				actual.SetCupboards(cb_tmp);
			}
			//negyedik �res sorig entry exithez rendel�se
			while(!((line=inputBR.readLine()).equals("*"))) {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Exit actual=(Exit) things.get(separate1.nextToken());
				actual.setEntry((Entry)things.get(separate1.nextToken()));
			}
			//v�g�ig �llatok l�trehoz�sa
			while((line=inputBR.readLine()) != null && !line.equals("*")) {
				StringTokenizer separate1=new StringTokenizer(line," ");
				//csak create parancsok bet�lt�se
				if (!separate1.nextToken().equals("create")) continue;
				
				Animal a = null;
				String type=separate1.nextToken();
				switch(type) {
					case "Panda": a= new Panda(); break;
					case "Orangutan": a= new Orangutan();break;
					case "ShyPanda":  a= new ShyPanda();break;
					case "HungryPanda": a= new HungryPanda(); break;
					case "LazyPanda": a= new LazyPanda();  break;
					default: successfullLoad=false;
				}
				
				if (type.equals("Orangutan")) { 
					orangutans.add((Orangutan)a);
					points.put((Orangutan)a, 0);
				}
				else pandas.add((Panda)a);
				
				if(a!=null) {
					String name=separate1.nextToken(); 
					things.put(name,a);
					String tileName=separate1.nextToken();
					Tile tile=(Tile)things.get(tileName);
					tile.Add(a);
					Tester.WriteOutput(type + " " + name + " L�TREHOZVA ITT: [" + tileName + "]", null);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			successfullLoad=false;
		}
		testThings=things;
		
		steppables = new Steppable[orangutans.size() + pandas.size() + tiles.size()];
		System.arraycopy(orangutans.toArray(), 0, steppables, 0, orangutans.size());
		System.arraycopy(pandas.toArray(), 0, steppables, orangutans.size(), pandas.size());
		System.arraycopy(tiles.toArray(), 0, steppables, orangutans.size() + pandas.size(), tiles.size());
		
		if(successfullLoad) Tester.WriteOutput("SIKERES BET�LT�S", null);
		else Tester.WriteOutput("SIKERTELEN BET�LT�S", null);
	}
	
	/**
	 * V�ge a j�t�knak, az adott or�ngut�n vesztett
	 * 
	 * @param o vesztes or�ngut�n
	 */
	public static void End(Orangutan o) {

	}
	
	/**
	 * Pontot ad az adott or�ngut�nnak
	 * 
	 * @param o or�ngut�n
	 */
	public static void AddPoint(Orangutan o) {

	}
	
	/**
	 * Steppable elt�vol�t�sa
	 * 
	 * @param s az adott l�ptethet� dolog
	 */
	public static void RemoveSteppable(Steppable s) {
		
	}
	
	/**
	 * L�ptethet� dolgok l�ptet�se
	 */
	public static void Update() {
		for (Steppable s: steppables) {
			s.Step();
		}
	}
	
	public static HashMap<String, Object> GetObjects() {
		return testThings;
	}
}

