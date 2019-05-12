package def;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
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
import java.awt.image.BufferedImage;
/**
 * J�t�kot reprezent�l� statikus oszt�ly
 */
public class Game {
	
	public static Coord scale=new Coord(110,110);

	/**
	 * L�ptethet� dolgok
	 */
	static private Steppable[] steppables;
	
	/**
	 * pontok t�rol�sa
	 */
	static private HashMap<Orangutan, Integer> points;
	
	
	private static Map<Tile, Coord> coords;
	//Az �llatok �s t�rgyak ezt haszn�lj�k
	private static Map<Tile, Coord> MVPcoords;	
	
	/**
	 * P�lya gener�l�sa, �s kapcsolatok be�ll�t�sa
	 */
	public static void Generate(String inputFileName, Window window) {
		//azonos�t�s n�v alapj�n
		coords = new HashMap<Tile, Coord>();
		MVPcoords = new HashMap<Tile, Coord>();
		
		HashMap<String, Object> things=new HashMap<String, Object>();
		
		points = new HashMap<Orangutan, Integer>();
		
		List<Tile> tiles = new ArrayList<Tile>();
		List<Panda> pandas = new ArrayList<Panda>();
		List<Orangutan> orangutans = new ArrayList<Orangutan>();
		List<TileView> tileViews = new ArrayList<TileView>();
		
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
				
				boolean weak=false;
				
				Tile actualTile=null;
				TileView actualTileView=null;
				
				//megfelelo t�pus l�trehoz�sa
				switch(separate.nextToken()) {
					case "nt":  
						actualTile=new Tile();
						actualTileView = new TileView(actualTile,null);
						break;
					case "wt":  
						actualTile=new WeakTile();
						weak = true;
						actualTileView = new WeakTileView((WeakTile)actualTile);
						break;
					case "cb": 
						actualTile=new Cupboard();
						actualTileView = new TileView(actualTile,ImageIO.read(new File("resources/cupb.jpg")));
						break;
					case "vm":  
						actualTile=new VendingMachine();
						actualTileView = new TileView(actualTile,ImageIO.read(new File("resources/vending.png")));
						break;
					case "sm":  
						actualTile=new SlotMachine();
						actualTileView = new TileView(actualTile,ImageIO.read(new File("resources/slot.png")));
						break;
					case "ac":  
						actualTile=new Armchair();
						actualTileView = new TileView(actualTile,ImageIO.read(new File("resources/armc.png")));
						break;
					case "en": 
						actualTile=new Entry();
						actualTileView = new TileView(actualTile,null);
						break;
					case "ex": 
						actualTile=new Exit();
						actualTileView = new TileView(actualTile,null);
						break;
					default: successfullLoad=false; break;
				}
				
				if(actualTile!=null) {
					things.put(name, actualTile);
					tiles.add(actualTile);
					tileViews.add(actualTileView);
					window.AddDrawable(actualTileView);
					
					int ycoord=Integer.parseInt(separate.nextToken());
					int xcoord=Integer.parseInt(separate.nextToken());
					
					
					coords.put(actualTile, new Coord(xcoord,ycoord));
				}
				
				
			}
			
			//m�sodik �res sorig szomsz�dokat �ll�t
			while(!(line=inputBR.readLine()).equals("*")) {
				//: lev�laszt�sa
				StringTokenizer separate1=new StringTokenizer(line,":");
				System.out.println(line);
				//tile akinek a szomsz�dait �ll�tjuk
				String name = separate1.nextToken();
				Tile actual=(Tile) things.get(name);
				//, lev�laszt�sa
				StringTokenizer separate2=new StringTokenizer(separate1.nextToken(),", ");
				//szomsz�dok azonos�t�sa
				ArrayList<Tile> neighbours=new ArrayList<Tile>();
				while(separate2.hasMoreTokens()) {
					neighbours.add((Tile)things.get(separate2.nextToken()));
				}
				Tile[] tiles_tmp = new Tile[neighbours.size()];
				System.arraycopy(neighbours.toArray(), 0, tiles_tmp, 0, neighbours.size());
				if (tiles_tmp == null) {
					System.out.println("ASD");
				}
				
				actual.SetNeighbours(tiles_tmp);
			}
			//tile n�zetek poligonj�nak sz�m�t�sa
			int k = 0;
			for(TileView tv : tileViews) {
				System.out.println(things.get(tv.getTile()) + " " + k);
				k++;
				try {
					if (tv != null) {
						tv.calculateEdges();
						MVPcoords.put(tv.getTile(), tv.GetCenter());
					}
				} catch (Exception e) {
					System.exit(0);
				}
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
	
	public static Coord GetCoords(Tile t) {
		return coords.get(t);
	}
	
	public static Coord MVPCoords(Tile t) {
		Coord c_ = MVPcoords.get(t);
		Coord c = new Coord(c_.GetX(), c_.GetY());
		c.Translate(2.0, 1.0);
		c = Coord.Scale(c, scale);
		return c;
	}
	
	public static void MoveOrangutanPointer(int o) {
		if (o == 0) ((Orangutan)steppables[0]).IncDir();
		else ((Orangutan)steppables[1]).IncDir();
	}
	
}

