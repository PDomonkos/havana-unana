package graphics.views;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import animal.Orangutan;
import def.Coord;
import def.Game;
import graphics.Drawable;
import tile.Tile;

public class OrangutanView extends Drawable {
	
	private Orangutan o;
	
	public OrangutanView(Orangutan o) {
		this.o = o;
		try {
			this.SetImage(ImageIO.read(new File("resources/orangutan_img.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Draw(Graphics g) {
		Tile t = o.getTile();
		Coord c = Game.MVPCoords(t);
		
		Tile m = o.getMarkedTile();
		if (m != null) {
			g.setColor(Color.WHITE);
			Coord c3 = Game.MVPCoords(m);
			g.drawOval((int)c3.GetX() - 25, (int)c3.GetY() - 25, 50, 50);
		}
		
		if (o.GetFollower() != null) {
			t = o.GetFollower().getTile();
			Coord c2 = Game.MVPCoords(t);
			g.setColor(Color.black);
			g.drawLine((int)c2.GetX(), (int)c2.GetY(), (int)c.GetX(), (int)c.GetY());
		}
		
		g.drawImage(img, (int)c.GetX() - 25, (int)c.GetY() - 25, 50, 50, null);
	}

}
