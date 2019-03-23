package scenario;

import animal.Orangutan;
import def.Logger;
import tile.Tile;
import tile.WeakTile;

public class Orangutan_falls_3 implements Scenario{

	Orangutan o;
	Tile t1;
	WeakTile wt;
	
	@Override
	public void execute() {
		init();
		run();
	}
	
	private void init() {
		Logger l=Logger.get_static_logger();
		
		o=new Orangutan();
		t1=new Tile();
		wt=new WeakTile();
		
		l.Add(o, "o");
		l.Add(t1, "t1");
		l.Add(wt, "wt");
		
		t1.Add(o);
		wt.SetNeighbours(new Tile[] {t1});
		t1.SetNeighbours(new Tile[] {wt});
		
		wt.set_count(1);
	}
	
	private void run() {
		o.Move(wt);
	}
	

	
}
