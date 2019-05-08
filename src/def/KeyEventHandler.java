package def;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import graphics.Window;

public class KeyEventHandler implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		///TODO: Game megfelelõ függvényeit hívni
		System.out.println(arg0.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
