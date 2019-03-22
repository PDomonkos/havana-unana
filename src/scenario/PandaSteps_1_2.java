package scenario;

import animal.Panda;
import def.Logger;
import tile.Tile;

// Panda foglalt mezore mozog
public class PandaSteps_1_2 implements Scenario {
	Panda p1, p2;
	Tile t1, t2;
	
	private void init() {
		Logger l = Logger.get_static_logger();
		
		p1 = new Panda();
		p2 = new Panda();
		t1 = new Tile();
		t2 = new Tile();
		
		l.Add(p1, "p1");
		l.Add(p2, "p2");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		
		t1.Add(p1);
		t2.Add(p2);
		t1.SetNeighbours(new Tile[] {t2});
		t2.SetNeighbours(new Tile[] {t1});
	}
	
	private void run() {
		p1.Step();
	}

	@Override
	public void execute() {
		init();
		run();
	}

}
