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
 * Játékot reprezentáló statikus osztály
 */
public class Game {

	/**
	 * Léptethetõ dolgok
	 */
	static private Steppable[] steppables;

	/**
	 * timer
	 */
	static private Timer timer;
	
	//ezt meg kéne oldani hogy hívja updatet
	
	/**
	 * pontok tárolása
	 */
	static private HashMap<Orangutan, Integer> points;
	
	
	 //Csak a protohoz, a dolgok átadása a testernek
	private static HashMap<String, Object> testThings;
	
	/**
	 * Pálya generálása, és kapcsolatok beállítása
	 */
	public static void Generate(String inputFileName) {
		//azonosítás név alapján
		HashMap<String, Object> things=new HashMap<String, Object>();
		//sikeresség vizsgálat
		boolean successfullLoad=true;
		try {
			FileReader inputFR = new FileReader(inputFileName);
			BufferedReader inputBR=new BufferedReader(inputFR);
			
			String line;
			
			//elso üres sorig létrehoz
			while((line=inputBR.readLine())!="") {
				StringTokenizer separate=new StringTokenizer(line," ");
				
				//neve
				String name=separate.nextToken();
				
				//megfelelo típus létrehozása
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
			//második üres sorig szomszédokat állít
			while((line=inputBR.readLine())!="") {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,": ");
				//tile akinek a szomszédait állítjuk
				Tile actual=(Tile) things.get(separate1.nextToken());
				//, leválasztása
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szomszédok azonosítása
				ArrayList<Tile> neighbours=new ArrayList<Tile>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Tile)things.get(separate2.nextToken()));
				}
				actual.SetNeighbours((Tile[])neighbours.toArray());
			}
			//harmadik üres sorig szekrények kapcsolatai
			while((line=inputBR.readLine())!="") {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Cupboard actual=(Cupboard) things.get(separate1.nextToken());
				//, leválasztása
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szekrénykapcsolatok azonosítása
				ArrayList<Cupboard> neighbours=new ArrayList<Cupboard>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Cupboard)things.get(separate2.nextToken()));
				}
				actual.SetCupboards((Cupboard[])neighbours.toArray());
			}
			//negyedik üres sorig entry exithez rendelése
			while((line=inputBR.readLine())!="") {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Exit actual=(Exit) things.get(separate1.nextToken());
				actual.setEntry((Entry)things.get(separate1.nextToken()));
			}
			//végéig állatok létrehozása
			while((line=inputBR.readLine())!=null) {
				StringTokenizer separate1=new StringTokenizer(line," ");
				//csak create parancsok betöltése
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
					Tester.WriteOutput(type + " " + name + " LÉTREHOZVA ITT: " + tile, null);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
			successfullLoad=false;
		}
		testThings=things;
		if(successfullLoad) Tester.WriteOutput("SIKERES BETÖLTÉS", null);
		else Tester.WriteOutput("SIKERTELEN BETÖLTÉS", null);
	}
	
	/**
	 * Vége a játéknak, az adott orángután vesztett
	 * 
	 * @param o vesztes orángután
	 */
	public static void End(Orangutan o) {

	}
	
	/**
	 * Pontot ad az adott orángutánnak
	 * 
	 * @param o orángután
	 */
	public static void AddPoint(Orangutan o) {

	}
	
	/**
	 * Steppable eltávolítása
	 * 
	 * @param s az adott léptethetõ dolog
	 */
	public static void RemoveSteppable(Steppable s) {
		
	}
	
	/**
	 * Léptethetõ dolgok léptetése
	 */
	public static void Update() {
		
	}
	
	public static HashMap<String, Object> GetObjects() {
		return testThings;
	}
}

