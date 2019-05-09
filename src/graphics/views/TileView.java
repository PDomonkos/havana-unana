package graphics.views;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import def.Coord;
import def.Game;
import graphics.Drawable;
import tile.Tile;

public class TileView extends Drawable {
	
	private Tile t;
	private List<Coord> edges;
	private int[] xs, ys;
	
	public TileView(Tile t) {
		this.t = t;
		
		edges=new ArrayList();
		
		
	}
	
	//WeakTileViewnak
	protected TileView() {}

	@Override
	public void Draw(Graphics g) {
		g.setColor(Color.black);
		g.drawPolygon(xs, ys, edges.size());
	}
	
	private int[] GetAllX() {
		int[] xs = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			xs[i] = (int)(edges.get(i).GetX() * Game.scale.GetX());
		}
		
		return xs;
	}
	
	private int[] GetAllY() {
		int[] ys = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			ys[i] = (int)(edges.get(i).GetY() * Game.scale.GetY());
		}
		
		return ys;
	}
	
	

	//szomsz�dosak-e?
	private boolean isNeighbour(Tile t1, Tile t2) {	
		for (Tile t : t2.GetNeighbours()) 
			if (t==t1)
				return true;
		return false;
	}
	
	//k�z�s szomsz�d ami nem az eredeti, ha van
	private Tile GetCommonNeighbour(Tile t1, Tile t2, Tile notThis ) {	
		for (Tile t1n : t1.GetNeighbours()) 
			if (isNeighbour(t1n,t2) && t1n!=notThis) 
				return t1n;
		return null;	
	}
	
	//sarkok kisz�mol�sa
	public void calculateEdges() {
		Tile tmp;
		
		//szomsz�dok t�rol�sa ideiglenesen
		Tile[] neighbours= t.GetNeighbours();
		
		//szomsz�d koordin�t�k t�rol�sa
		List<Coord> nCoords = new ArrayList<Coord>();
		for (Tile n : neighbours) {
			nCoords.add(Game.GetCoords(n));
		} 
		//saj�t koordin�ta
		Coord c0 = Game.GetCoords(t);
		
		//p�ros�val bej�rja a szomsz�dokat
		for (int i = 0; i < nCoords.size();i++) {
			
			//ha szomsz�dosak a bel�l�k keletkez� 3sz�g k�z�ppontja lesz az egyik cs�cs
			//ha nem, de van m�s k�z�s szomsz�duk akkor a keletkez� 4sz�g k�z�ppontja kell
			//
			if( isNeighbour(neighbours[i],neighbours[(i+1) % nCoords.size()]) ) {
				Coord c1 = nCoords.get(i);
				Coord c2 = nCoords.get((i+1) % nCoords.size());
///ez szar lesz m�g				
				edges.add( new Coord( (c0.GetX() + c1.GetX() + c2.GetX())/3 , (c0.GetY() + c1.GetY() + c2.GetY())/3 ));			
			}else if( ( tmp=GetCommonNeighbour(neighbours[i],neighbours[(i+1) % nCoords.size()],t))!=null ) {
				if ( !isNeighbour(tmp,t) ) {
					Coord c1 = nCoords.get(i);
					Coord c2 = nCoords.get((i+1) % nCoords.size());
					Coord c3 = Game.GetCoords(tmp);
					edges.add( new Coord( (c0.GetX() + c1.GetX() + c2.GetX() + c3.GetX())/4 , (c0.GetY() + c1.GetY() + c2.GetY() + c3.GetY())/4 ));
				}
			}	
		}
		
		//ha valamelyik a sz�l�n van:
		int xMax=13;
		int yMax=5;
		
		//bal fels� sarok
		//jobb fels�
		//jobb als�
		//bal als�
		//fels� sz�le
		//als�
		//bal
		//jobb
		if(c0.GetX()==0 && c0.GetY()==0) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(0,cc.GetY()) );
			edges.add( new Coord(0,0) );
			edges.add( new Coord(edges.get(0).GetX(),0) );
		}else if(c0.GetX()==xMax && c0.GetY()==0) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(cc.GetX(),0) );
			edges.add( new Coord(xMax,0) );
			edges.add( new Coord(xMax,edges.get(0).GetY()) );		
		}else if(c0.GetX()==xMax && c0.GetY()==yMax) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(xMax,cc.GetY()) );
			edges.add( new Coord(xMax,yMax) );
			edges.add( new Coord(edges.get(0).GetX(),yMax) );		
		}
		else if(c0.GetX()==0 && c0.GetY()==yMax) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(cc.GetX(),yMax) );	
			edges.add( new Coord(0,yMax) );
			edges.add( new Coord(0,edges.get(0).GetY()) );		
		}else if(c0.GetY()==0) {
			edges.add( new Coord(edges.get(edges.size()-1).GetX(),0) );	
			edges.add( new Coord(edges.get(0).GetX(),0) );	
		}else if(c0.GetY()==yMax) {
			edges.add( new Coord(edges.get(edges.size()-1).GetX(),yMax) );	
			edges.add( new Coord(edges.get(0).GetX(),yMax) );	
		}
		else if(c0.GetX()==0) {
			edges.add( new Coord(0,edges.get(edges.size()-1).GetY()) );	
			edges.add( new Coord(0,edges.get(0).GetY()) );	
		}
		else if(c0.GetX()==xMax) {
			edges.add( new Coord(xMax,edges.get(edges.size()-1).GetY()) );	
			edges.add( new Coord(xMax,edges.get(0).GetY()) );	
		}	
		

		xs = GetAllX();
		ys = GetAllY();
	}


}
