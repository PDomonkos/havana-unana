package graphics;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class AnimatedSprite implements ActionListener {
	private List<BufferedImage> images;
	int index;
	
	public AnimatedSprite(int n, int dt_ms, String path) {
		index = 0;
		images = new ArrayList<BufferedImage>();
		try {
			BufferedImage bi = ImageIO.read(new File(path));
			int w = bi.getWidth() / n;
			for (int i = 0; i < n; i++) {
				int offset = w * i;
				BufferedImage si = bi.getSubimage(offset, 0, w, bi.getHeight());
				images.add(si);
			}
			Timer timer = new Timer(dt_ms, this);
			timer.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int getFrame() {
		//9 - 24
		if ((index / 15) % 2 == 0) {
			return index % 15 + 9;
		}
		return 15 - (index % 15) + 9;
	}
	
	public void Draw(Graphics g, int x, int y) {
		g.drawImage(images.get(getFrame()), x, y, 100, 100, null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		index++;
	}
}
