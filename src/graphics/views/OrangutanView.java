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
		Coord c = Game.GetCoords(t);
		c = Coord.Scale(c, Game.scale);
		
		if (o.GetFollower() != null) {
			t = o.GetFollower().getTile();
			Coord c2 = Game.GetCoords(t);
			c2 = Coord.Scale(c, Game.scale);
			g.setColor(Color.black);
			g.drawLine((int)c2.GetX(), (int)c2.GetY(), (int)c.GetX(), (int)c.GetY());
		}
		
		g.drawImage(img, (int)c.GetX(), (int)c.GetY(), 50, 50, null);
	}

}
