package graphics.views;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import animal.Animal;
import def.Coord;
import def.Game;
import graphics.Drawable;
import tile.Tile;

public class AnimalView extends Drawable {
	
	private Animal a;
	
	public AnimalView(Animal a) {		
		this.a = a;
		try {
			this.SetImage(ImageIO.read(new File("resources/panda_img.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Draw(Graphics g) {
		Tile t = a.getTile();
		Coord c = Game.MVPCoords(t);
		
		if (a.GetFollower() != null) {
			t = a.GetFollower().getTile();
			Coord c2 = Game.MVPCoords(t);
			g.setColor(Color.black);
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(6));
			g2.drawLine((int)c2.GetX(), (int)c2.GetY(), (int)c.GetX(), (int)c.GetY());
		}
		
		g.drawImage(img, (int)c.GetX() - 40, (int)c.GetY() - 40, 80, 80, null);
	}

}
