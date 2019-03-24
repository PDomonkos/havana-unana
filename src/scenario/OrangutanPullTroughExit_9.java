package scenario;

import animal.Orangutan;
import animal.Panda;
import def.Game;
import def.Logger;
import tile.Entry;
import tile.Exit;
import tile.Tile;

public class OrangutanPullTroughExit_9 implements Scenario {
	Tile t0, t1, t2;
	Exit ex;
	Entry en;
	Orangutan o;
	Panda p;
	Game g;
	
	
	/*
	 * t0---t1---ex---en---t2
	 * p    o  ->
	 */
	
	private void init() {
		Logger l = Logger.get_static_logger();
		Logger.breakLine();
		
		t0 = new Tile();
		t1 = new Tile();
		t2 = new Tile();
		ex = new Exit();
		en = new Entry();
		o = new Orangutan();
		p = new Panda();
		g = new Game();
		
		Tile.setGame(g);
		
		l.Add(t0, "t0");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		l.Add(ex, "ex");
		l.Add(en, "en");
		l.Add(o, "o");
		l.Add(p, "p");
		l.Add(g, "g");
		
		t0.SetNeighbours(new Tile[] {t1});
		t1.SetNeighbours(new Tile[] {t0, ex});
		en.SetNeighbours(new Tile[] {t2});
		
		ex.setEntry(en);
		
		t0.Add(p);
		t1.Add(o);
		
		o.Grab(p);
		
		Logger.breakLine();
	}
	
	private void run() {
		o.Move(ex);
		ex.Step();
		o.Move(t2);
	}

	@Override
	public void execute() {
		init();
		run();
	}

}
