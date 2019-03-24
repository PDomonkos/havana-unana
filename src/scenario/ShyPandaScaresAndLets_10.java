package scenario;

import animal.Panda;
import animal.ShyPanda;
import def.Logger;
import tile.SlotMachine;
import tile.Tile;

public class ShyPandaScaresAndLets_10 implements Scenario {
	/*
	 *           s
	 *           |
	 *    t1-----t2
	 * follower  p
	 */

	SlotMachine s;
	Tile t1, t2;
	ShyPanda p;
	Panda follower;
	
	private void init() {
		Logger l = Logger.get_static_logger();
		Logger.breakLine();
		
		s = new SlotMachine();
		t1 = new Tile();
		t2 = new Tile();
		p = new ShyPanda();
		follower = new Panda();
		
		l.Add(s, "s");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		l.Add(p, "p");
		l.Add(follower, "follower");
		
		s.SetNeighbours(new Tile[] {t2});
		t1.SetNeighbours(new Tile[] {t2});
		t2.SetNeighbours(new Tile[] {t1, s});
		
		t1.Add(follower);
		t2.Add(p);
		
		p.Grab(follower);
		
		Logger.breakLine();
	}
	
	private void run() {
		s.Step();
	}
	
	@Override
	public void execute() {
		init();
		run();
	}

}
