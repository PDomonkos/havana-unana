package graphics.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
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
	private int id;
	
	public OrangutanView(Orangutan o, int n) {
		this.o = o;
		id =n;
		try {
			if (id == 0)
				this.SetImage(ImageIO.read(new File("resources/orangutan_img.png")));
			else
				this.SetImage(ImageIO.read(new File("resources/orangutan_img0.png")));
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
			Coord c3 = Game.MVPCoords(m);
			Shape circle = new Ellipse2D.Double((int)c3.GetX() - 25, (int)c3.GetY() - 25, 50, 50);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(8));
			if (id==0)
				g2.setColor(Color.white);
			else
				g2.setColor(Color.black);
			g2.draw(circle);
		}
		
		if (o.GetFollower() != null) {
			t = o.GetFollower().getTile();
			Coord c2 = Game.MVPCoords(t);
			g.setColor(Color.black);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(6));
			g2.drawLine((int)c2.GetX(), (int)c2.GetY(), (int)c.GetX(), (int)c.GetY());
		}
		
		g.drawImage(img, (int)c.GetX() - 40, (int)c.GetY() - 40, 80, 80, null);
	}

}
