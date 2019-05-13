package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import def.Game;
import def.KeyEventHandler;
import def.MenuHandler;


public class Window extends JFrame implements ActionListener {
	
	private static final int W_WIDTH = 1920, W_HEIGHT = 1000;
	private static final float DRAW_DT = (float) (1.0 / 30.0), UPDATE_DT = (float) (1.5);
	private List<Drawable> drawables;
	private JPanel pane;
	private Timer draw_timer, update_timer;
	private boolean stop;
	
	public Window() {
		// JFrame be�ll�t�s
		super("PandaPlaza");
		setSize(W_WIDTH, W_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		stop = false;
		
		// Menu bar
		JMenuBar menuBar;
		JMenu menu1, menu2;

		//Create the menu bar.
		menuBar = new JMenuBar();
		
		// Menu handler
		MenuHandler mh = new MenuHandler(this);

		//Build the first menu.
		menu1 = new JMenu("New Game");
		menu1.addMouseListener(mh);
		menuBar.add(menu1);
		
		menu2 = new JMenu("Exit");
		menu2.addMouseListener(mh);
		menuBar.add(menu2);
		
		this.setJMenuBar(menuBar);
		
		// P�lya �s �llatok bet�lt�s
		InitGame();
		
		// Panel, amire rajzolunk
		pane = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
				// Hatter
				g.setColor(Color.black);
				g.fillRect(0, 0, W_WIDTH, W_HEIGHT);
				
				
				// Mindenki rajzol
				for (Drawable d : drawables) {
					d.Draw(g);
				}
				
				// Pontok
				g.setColor(Color.white);
				g.drawString("Player1: " + Game.GetPoint(0), 10, 10);
				g.drawString("Player2: " + Game.GetPoint(1), 10, 30);
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
	public void InitGame() {
		drawables = new ArrayList<Drawable>();
		Game.Generate("map1.txt", this);
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
			if (!stop) {
				revalidate();
				repaint();
			}
		} else {
			// Update
			if (!stop) {
				Game.Update();
			}
		}
	}
}
