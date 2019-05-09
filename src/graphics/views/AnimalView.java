package graphics.views;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import animal.Animal;
import def.Coord;
import def.Game;
import graphics.Drawable;

public class AnimalView extends Drawable {
	
	private Animal a;
	
	public AnimalView(Animal a) {
		
		BufferedImage image;
		try {
			image = ImageIO.read(new File("resources/panda.png"));
			this.SetImage(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.a = a;
	}

	@Override
	public void Draw(Graphics g) {		
		Coord actual = Game.GetCoords(a.getTile());
			g.drawImage(img, 0, 0, 50, 50, null);

			System.out.println("Sikertelen állat kirajzolás.");
	}

}
