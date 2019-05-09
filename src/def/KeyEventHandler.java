package def;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import graphics.Window;

public class KeyEventHandler implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar() == 'a') {
			Game.MoveOrangutanPointer(0);
		} else if (arg0.getKeyChar() == 's') {
			Game.MoveOrangutanPointer(1);
		} else if (arg0.getKeyChar() == ' ') {
			Game.Update();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
