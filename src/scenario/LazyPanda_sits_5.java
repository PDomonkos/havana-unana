package scenario;

import animal.LazyPanda;
import def.Logger;
import tile.Armchair;
import tile.Tile;

public class LazyPanda_sits_5 implements Scenario{

	LazyPanda p;
	Tile t;
	Armchair a;
	
	@Override
	public void execute() {
		init();
		run();
	}

	private void init() {
		Logger l=Logger.get_static_logger();
		
		p=new LazyPanda();
		t=new Tile();
		a=new Armchair();
		
		l.Add(p, "p");
		l.Add(t, "t");
		l.Add(a, "a");
		
		t.Add(p);
		
		t.SetNeighbours(new Tile[] {a});
		a.SetNeighbours(new Tile[] {t});
		
	}
	
	private void run() {
		a.Step();
	}
}
