package graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Drawable {
	
	protected BufferedImage img;
	
	public abstract void Draw(Graphics g);
	
	public void SetImage(BufferedImage bi) {
		this.img = bi;
	}
	
}
