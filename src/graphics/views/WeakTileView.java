package graphics.views;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Drawable;
import tile.WeakTile;

public class WeakTileView extends TileView {
	
	
	public WeakTileView(WeakTile wt) {
		super(wt);
	}

	@Override
	public void Draw(Graphics g) {
		float colorRatio=(float)(((WeakTile)t).GetCount())/(float)20;
		System.out.println(colorRatio+"\n");
		g.setColor(new Color(colorRatio * 1.0f, colorRatio * 0.08f, colorRatio * 0.56f));
		g.fillPolygon(xs, ys, edges.size());
	}

}
