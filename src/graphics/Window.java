package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import animal.Orangutan;
import def.Game;
import def.KeyEventHandler;
import graphics.views.OrangutanView;


public class Window extends JFrame implements ActionListener {
	
	private static final int W_WIDTH = 720, W_HEIGHT = 480;
	private static final float DRAW_DT = (float) (1.0 / 30.0), UPDATE_DT = (float) (1.0 / 2.0);
	private List<Drawable> drawables;
	private JPanel pane;
	private Timer draw_timer, update_timer;
	
	public Window() {
		// JFrame be�ll�t�s
		super("PandaPlaza");
		setSize(W_WIDTH, W_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		// P�lya �s �llatok bet�lt�s
		InitGame();
		
		// Panel, amire rajzolunk
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				g.setColor(Color.red);
				g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
				
				
				// Mindenki rajzol
				for (Drawable d : drawables) {
					d.Draw(g);
				}
			}
		};
		
		// Panel hozz�ad�sa
		add(pane);
		// KeyListener hozz�ad�sa
		addKeyListener(new KeyEventHandler());
		
		// Game timer indit�s
		update_timer = new Timer((int) (UPDATE_DT * 1000), this);
		update_timer.start();
		
		// Rajzol�shoz timer indit�s
		draw_timer = new Timer((int) (DRAW_DT * 1000), this);
		draw_timer.start();
	}
	
	// P�lya �s �llatok bet�lt�s
	private void InitGame() {
		drawables = new ArrayList<Drawable>();
		Game.Generate("maps/test_map1.txt", this);
	}
	
	public void AddDrawable(Drawable d) {
		drawables.add(d);
	}
	
	public void RemoveDrawable(Drawable d) {
		drawables.remove(d);
	}
	
	public static void main(String[] args) {
		new Window();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == draw_timer) {
			// �jrarajzol�s
			revalidate();
			repaint();
		} else {
			// Update
			Game.Update();
		}
	}
}
