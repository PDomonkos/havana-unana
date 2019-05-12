package graphics.views;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Drawable;
import tile.WeakTile;

public class WeakTileView extends TileView {
	
	
	public WeakTileView(WeakTile wt) {
		super(wt,null);
	}

	@Override
	public void Draw(Graphics g) {
		float colorRatio=(float)(((WeakTile)t).GetCount())/(float)20;
		g.setColor(new Color(colorRatio * 0.7f, colorRatio * 0.1f, colorRatio * 0.1f));
		g.fillPolygon(xs, ys, edges.size());
	}

}
