package def;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;

import graphics.Window;

public class MenuHandler implements MouseListener {
	private Window w;
	
	public MenuHandler(Window w) {
		this.w = w;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String text = ((JMenu)e.getSource()).getText();
		if (text.equals("New Game")) {
			Game.Pause();
			w.InitGame();
			Game.Continue();
		} else if (text.equals("Exit")) {
			System.exit(0);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
