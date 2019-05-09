package graphics.views;

import java.awt.Graphics;

import graphics.Drawable;
import tile.Tile;

public class TileView extends Drawable {
	
	private Tile t;
	
	public TileView(Tile t) {
		this.t = t;
	}
	
	//WeakTileViewnak
	protected TileView() {}

	@Override
	public void Draw(Graphics g) {
		// TODO Auto-generated method stub

	}
	
	public void calculateEdges(){
		
	}

}
