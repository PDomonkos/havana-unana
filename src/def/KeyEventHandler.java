package def;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class KeyEventHandler implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == 'a') {
			Game.MoveOrangutanPointer(0);
		} else if (arg0.getKeyChar() == 's') {
			Game.MoveOrangutanPointer(1);
		} else if (arg0.getKeyChar() == ' ') {
			Game.Update();
		} else if (arg0.getKeyChar() == 'r') {
			MasterThread t = new MasterThread();
			Thread thread = new Thread(t);
			thread.start();
			
			Game.drawmode = (Game.drawmode == 0 ? 1 : 0);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
