package graphics.views;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Drawable;
import tile.WeakTile;

public class WeakTileView extends TileView {
	
	private WeakTile wt;
	
	public WeakTileView(WeakTile wt) {
		this.wt = wt;
	}

	@Override
	public void Draw(Graphics g) {
		float colorRatio=(float)(wt.GetCount())/(float)20;
		g.setColor(new Color(255 * colorRatio, 20 * colorRatio, 144 * colorRatio));
		g.fillPolygon(xs, ys, edges.size());
	}

}
