package def;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Timer;

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

/**
 * J�t�kot reprezent�l� statikus oszt�ly
 */
public class Game {

	/**
	 * L�ptethet� dolgok
	 */
	static private Steppable[] steppables;

	/**
	 * timer
	 */
	static private Timer timer;
	
	//ezt meg k�ne oldani hogy h�vja updatet
	
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
		//sikeress�g vizsg�lat
		boolean successfullLoad=true;
		try {
			FileReader inputFR = new FileReader(inputFileName);
			BufferedReader inputBR=new BufferedReader(inputFR);
			
			String line;
			
			//elso �res sorig l�trehoz
			while((line=inputBR.readLine())!="") {
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
			}
			//m�sodik �res sorig szomsz�dokat �ll�t
			while((line=inputBR.readLine())!="") {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,": ");
				//tile akinek a szomsz�dait �ll�tjuk
				Tile actual=(Tile) things.get(separate1.nextToken());
				//, lev�laszt�sa
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szomsz�dok azonos�t�sa
				ArrayList<Tile> neighbours=new ArrayList<Tile>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Tile)things.get(separate2.nextToken()));
				}
				actual.SetNeighbours((Tile[])neighbours.toArray());
			}
			//harmadik �res sorig szekr�nyek kapcsolatai
			while((line=inputBR.readLine())!="") {
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
				actual.SetCupboards((Cupboard[])neighbours.toArray());
			}
			//negyedik �res sorig entry exithez rendel�se
			while((line=inputBR.readLine())!="") {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Exit actual=(Exit) things.get(separate1.nextToken());
				actual.setEntry((Entry)things.get(separate1.nextToken()));
			}
			//v�g�ig �llatok l�trehoz�sa
			while((line=inputBR.readLine())!=null) {
				StringTokenizer separate1=new StringTokenizer(line," ");
				//csak create parancsok bet�lt�se
				if(separate1.nextToken()!="create")continue;
				
				Animal a = null;
				String type=separate1.nextToken();
				switch(type) {
					case "Panda": a= new Panda(); break;
					case "Orangutan": a= new Orangutan();  break;
					case "ShyPanda":  a= new ShyPanda();break;
					case "HungryPanda": a= new HungryPanda(); break;
					case "LazyPanda": a= new LazyPanda();  break;
					default: successfullLoad=false;
				}
				if(a!=null) {
					String name=separate1.nextToken(); 
					things.put(name,a);
					String tile=separate1.nextToken();
					a.SetTile((Tile)things.get(tile));
					Tester.WriteOutput(type + " " + name + " L�TREHOZVA ITT: " + tile, null);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			successfullLoad=false;
		}
		testThings=things;
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
		
	}
	
	public static HashMap<String, Object> GetObjects() {
		return testThings;
	}
}

