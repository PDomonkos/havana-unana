package graphics.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import def.Coord;
import def.Game;
import graphics.Drawable;
import tile.Tile;

public class TileView extends Drawable {
	
	protected Tile t;
	protected List<Coord> edges;
	protected int[] xs;
	protected int[] ys;

	private Color c;
	
	BufferedImage img;
	
	public TileView(Tile t,BufferedImage _img) {
		this.t = t;
		
		edges=new ArrayList();
		
		img=_img;
		
		//ez szebb �gy
		Random rd = new Random();
		c = new Color(140 + (int) (rd.nextDouble() * 40.0), (int) (rd.nextDouble() * 60.0) , (int) (rd.nextDouble() * 40.0));
		
	}
	
	//WeakTileViewnak
	protected TileView() {}

	@Override
	public void Draw(Graphics g) {
		g.setColor(c);
		g.fillPolygon(xs, ys, edges.size());
		g.setColor(Color.black);
		g.drawPolygon(xs, ys, edges.size());
		
		Coord c=Game.MVPCoords(t);
		if(img!=null)
		g.drawImage(img, (int)c.GetX() - 25, (int)c.GetY() - 25, 50, 50, null);
	}
	
	public Tile getTile() { return t; }
	
	private int[] GetAllX() {
		int[] xs = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			xs[i] = (int)((edges.get(i).GetX() + 2) * Game.scale.GetX());
		}
		
		return xs;
	}
	
	private int[] GetAllY() {
		int[] ys = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			ys[i] = (int)((edges.get(i).GetY() + 1) * Game.scale.GetY());
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
		int xMax=12;
		int xMin=1;
		int yMax=5;
		int yMin=1;
		
		//bal fels� sarok
		//jobb fels�
		//jobb als�
		//bal als�
		//fels� sz�le
		//als�
		//bal
		//jobb
		if(c0.GetX()==xMin && c0.GetY()==yMin) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(xMin-1,cc.GetY()) );
			edges.add( new Coord(xMin-1,yMin-1) );
			edges.add( new Coord(edges.get(0).GetX(),yMin-1) );
		}else if(c0.GetX()==xMax && c0.GetY()==yMin) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(cc.GetX(),yMin-1) );
			edges.add( new Coord(xMax+1,yMin-1) );
			edges.add( new Coord(xMax+1,edges.get(0).GetY()) );		
		}else if(c0.GetX()==xMax && c0.GetY()==yMax) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(xMax+1,cc.GetY()) );
			edges.add( new Coord(xMax+1,yMax+1) );
			edges.add( new Coord(edges.get(0).GetX(),yMax+1) );		
		}
		else if(c0.GetX()==xMin && c0.GetY()==yMax) {
			Coord cc=edges.get(edges.size()-1);
			edges.add( new Coord(cc.GetX(),yMax+1) );	
			edges.add( new Coord(xMin-1,yMax+1) );
			edges.add( new Coord(xMin-1,edges.get(0).GetY()) );		
		}else if(c0.GetY()==yMin) {
			edges.add( new Coord(edges.get(edges.size()-1).GetX(),yMin-1) );	
			edges.add( new Coord(edges.get(0).GetX(),yMin-1) );	
		}else if(c0.GetY()==yMax) {
			edges.add( new Coord(edges.get(edges.size()-1).GetX(),yMax+1) );	
			edges.add( new Coord(edges.get(0).GetX(),yMax+1) );	
		}
		else if(c0.GetX()==xMin) {
			edges.add( new Coord(xMin-1,edges.get(edges.size()-1).GetY()) );	
			edges.add( new Coord(xMin-1,edges.get(0).GetY()) );
		}
		else if(c0.GetX()==xMax) {
			edges.add( new Coord(xMax+1,edges.get(edges.size()-1).GetY()) );	
			edges.add( new Coord(xMax+1,edges.get(0).GetY()) );	
		}	// innent�l j�n a 2 fok� cs�csok ronda de m�k�d� megold�sa
		else if(c0.GetY()==yMin-1) {
			edges.clear();
			edges.add(new Coord(nCoords.get(1).GetX(),yMin-1));
			edges.add(new Coord(nCoords.get(0).GetX(),yMin-1));
			edges.add(new Coord(nCoords.get(0).GetX(),yMin-2));
			edges.add(new Coord(nCoords.get(1).GetX(),yMin-2));	
		}	
		else if(c0.GetY()==yMax+1) {
			edges.clear();
			edges.add(new Coord(nCoords.get(1).GetX(),yMax+1));
			edges.add(new Coord(nCoords.get(0).GetX(),yMax+1));
			edges.add(new Coord(nCoords.get(0).GetX(),yMax+2));
			edges.add(new Coord(nCoords.get(1).GetX(),yMax+2));	
		}
		else if(c0.GetX()==xMax+1) {
			edges.clear();
			edges.add(new Coord(xMax+1,nCoords.get(1).GetY()));
			edges.add(new Coord(xMax+2,nCoords.get(1).GetY()));
			edges.add(new Coord(xMax+2,nCoords.get(0).GetY()));
			edges.add(new Coord(xMax+1,nCoords.get(0).GetY()));
		}
		else if(c0.GetX()==xMin-1) {
			edges.clear();
			edges.add(new Coord(xMin-1,nCoords.get(1).GetY()));
			edges.add(new Coord(xMin-2,nCoords.get(1).GetY()));
			edges.add(new Coord(xMin-2,nCoords.get(0).GetY()));
			edges.add(new Coord(xMin-1,nCoords.get(0).GetY()));
		}
		
		xs = GetAllX();
		ys = GetAllY();
		
	}
	
	//edges k�z�ppontj�nak elk�r�se
	public Coord GetCenter() {
		double x=0.0;
		double y=0.0;
		for (Coord e : edges) {
			x+=e.GetX();
			y+=e.GetY();
		}
		x=x/edges.size();
		y=y/edges.size();
		return new Coord(x,y);
	}


}
