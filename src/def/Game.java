package def;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.Timer;

import animal.Animal;
import animal.HungryPanda;
import animal.LazyPanda;
import animal.Orangutan;
import animal.Panda;
import animal.ShyPanda;
import graphics.Window;
import graphics.views.AnimalView;
import graphics.views.OrangutanView;
import graphics.views.TileView;
import graphics.views.WeakTileView;
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
 * Játékot reprezentáló statikus osztály
 */
public class Game {
	
	public static Coord scale=new Coord(10,10);

	/**
	 * Léptethetõ dolgok
	 */
	static private Steppable[] steppables;
	
	/**
	 * pontok tárolása
	 */
	static private HashMap<Orangutan, Integer> points;
	
	
	private static Map<Tile, Coord> coords;
	
	/**
	 * Pálya generálása, és kapcsolatok beállítása
	 */
	public static void Generate(String inputFileName, Window window) {
		//azonosítás név alapján
		coords = new HashMap<Tile, Coord>();
		
		HashMap<String, Object> things=new HashMap<String, Object>();
		
		points = new HashMap<Orangutan, Integer>();
		
		List<Tile> tiles = new ArrayList<Tile>();
		List<Panda> pandas = new ArrayList<Panda>();
		List<Orangutan> orangutans = new ArrayList<Orangutan>();
		List<TileView> tileViews = new ArrayList<TileView>();
		
		//sikeresség vizsgálat
		boolean successfullLoad=true;
		try {
			FileReader inputFR = new FileReader(inputFileName);
			BufferedReader inputBR=new BufferedReader(inputFR);
			
			String line;
			
			//elso üres sorig létrehoz
			while(!(line=inputBR.readLine()).equals("*")) {
				StringTokenizer separate=new StringTokenizer(line," ");
				//neve
				String name=separate.nextToken();
				
				boolean weak=false;
				
				//megfelelo típus létrehozása
				switch(separate.nextToken()) {
					case "nt":  things.put(name, new Tile()); break;
					case "wt":  things.put(name, new WeakTile()); weak=true; break;
					case "cb":  things.put(name, new Cupboard()); break;
					case "vm":  things.put(name, new VendingMachine()); break;
					case "sm":  things.put(name, new SlotMachine()); break;
					case "ac":  things.put(name, new Armchair()); break;
					case "en":  things.put(name, new Entry()); break;
					case "ex":  things.put(name, new Exit()); break;
					default: successfullLoad=false; break;
				}
				
				Tile actualTile=(Tile)things.get(name);
				tiles.add(actualTile);
				
				//innentol view kezelés
				int xcoord=Integer.parseInt(separate.nextToken());
				int ycoord=Integer.parseInt(separate.nextToken());
				
				if(weak) {
					actualTile.set_count(20);
					tileViews.add(new WeakTileView((WeakTile)actualTile));
				}
				else
					tileViews.add(new TileView(actualTile));
				
				window.AddDrawable(tileViews.get(tileViews.size()-1));
				
				coords.put(actualTile, new Coord(xcoord,ycoord));
			}
			
			//második üres sorig szomszédokat állít
			while(!(line=inputBR.readLine()).equals("*")) {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,":");
				//tile akinek a szomszédait állítjuk
				Tile actual=(Tile) things.get(separate1.nextToken());
				//, leválasztása
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szomszédok azonosítása
				ArrayList<Tile> neighbours=new ArrayList<Tile>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Tile)things.get(separate2.nextToken()));
				}
				Tile[] tiles_tmp = new Tile[neighbours.size()];
				System.arraycopy(neighbours.toArray(), 0, tiles_tmp, 0, neighbours.size());
				actual.SetNeighbours(tiles_tmp);
			}
			
			//tile nézetek poligonjának számítása
			for(TileView tv : tileViews) {
				tv.calculateEdges();
			}
			
			//harmadik üres sorig szekrények kapcsolatai
			while(!(line=inputBR.readLine()).equals("*")) {
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
				
				Cupboard[] cb_tmp = new Cupboard[neighbours.size()];
				System.arraycopy(neighbours.toArray(), 0, cb_tmp, 0, neighbours.size());
				//actual.SetNeighbours(cb_tmp); Nem a szomszédokat kell állítani, hanem a szekrényszomszédot
				actual.SetCupboards(cb_tmp);
			}
			//negyedik üres sorig entry exithez rendelése
			while(!((line=inputBR.readLine()).equals("*"))) {
				//: leválasztása
				StringTokenizer separate1=new StringTokenizer(line,": ");
				Exit actual=(Exit) things.get(separate1.nextToken());
				actual.setEntry((Entry)things.get(separate1.nextToken()));
			}
			//végéig állatok létrehozása
			while((line=inputBR.readLine()) != null && !line.equals("*")) {
				StringTokenizer separate1=new StringTokenizer(line," ");
				//csak create parancsok betöltése
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
					
					OrangutanView ov=new OrangutanView((Orangutan)a);
					window.AddDrawable(ov);
				}
				else {
					pandas.add((Panda)a);
					
					AnimalView av=new AnimalView(a);
					window.AddDrawable(av);
				}
				
				if(a!=null) {
					String name=separate1.nextToken(); 
					things.put(name,a);
					String tileName=separate1.nextToken();
					Tile tile=(Tile)things.get(tileName);
					tile.Add(a);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			successfullLoad=false;
		}
		
		steppables = new Steppable[orangutans.size() + pandas.size() + tiles.size()];
		System.arraycopy(orangutans.toArray(), 0, steppables, 0, orangutans.size());
		System.arraycopy(pandas.toArray(), 0, steppables, orangutans.size(), pandas.size());
		System.arraycopy(tiles.toArray(), 0, steppables, orangutans.size() + pandas.size(), tiles.size());
		
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
		for (Steppable s: steppables) {
			s.Step();
		}
	}
	
	public static Coord GetCoords(Tile t) {
		return coords.get(t);
	}
	
	public static void MoveOrangutanPointer(int o) {
		if (o == 0) ((Orangutan)steppables[0]).IncDir();
		else ((Orangutan)steppables[1]).IncDir();
	}
	
}

