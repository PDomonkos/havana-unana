package graphics.views;

import java.awt.Graphics;
import java.util.List;

import def.Coord;
import graphics.Drawable;
import tile.Tile;

public class TileView extends Drawable {
	
	private Tile t;
	private List<Coord> edges;
	private int[] xs, ys;
	
	public TileView(Tile t) {
		this.t = t;
		
		xs = GetAllX();
		ys = GetAllY();
	}

	@Override
	public void Draw(Graphics g) {
		g.fillPolygon(xs, ys, edges.size());
	}
	
	private int[] GetAllX() {
		int[] xs = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			xs[i] = (int)edges.get(i).GetX();
		}
		
		return xs;
	}
	
	private int[] GetAllY() {
		int[] ys = new int[edges.size()];
		
		for (int i = 0; i < edges.size(); i++) {
			ys[i] = (int)edges.get(i).GetY();
		}
		
		return ys;
	}

}
