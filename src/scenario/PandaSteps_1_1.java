package scenario;

import animal.Panda;
import def.Logger;
import tile.Tile;

// Panda ures mezore mozog
public class PandaSteps_1_1 implements Scenario {
	private Panda p;
	private Tile t1, t2;	
	
	private void init() {
		Logger l = Logger.get_static_logger();
		
		p = new Panda();
		t1 = new Tile();
		t2 = new Tile();
		
		l.Add(p, "panda");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		
		t1.Add(p);
		t1.SetNeighbours(new Tile[] {t2});
		t2.SetNeighbours(new Tile[] {t1});
	}
	
	private void run() {
		p.Step();
	}

	@Override
	public void execute() {
		this.init();
		this.run();
	}

}
