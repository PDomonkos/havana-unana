package scenario;

import animal.Orangutan;
import animal.Panda;
import def.Logger;
import tile.Cupboard;
import tile.Tile;

public class OrangutanPullTroughCupboard_8 implements Scenario {
	
	Orangutan o;
	Cupboard cb1, cb2;
	Tile t1, t2, t3, t4;
	Panda follower;
	
	private void init() {
		Logger l = Logger.get_static_logger();
		Logger.breakLine();
		
		o = new Orangutan();
		cb1 = new Cupboard();
		cb2 = new Cupboard();
		t1 = new Tile();
		t2 = new Tile();
		t3 = new Tile();
		t4 = new Tile();
		follower = new Panda();
		
		l.Add(o, "o");
		l.Add(cb1, "cb1");
		l.Add(cb2, "cb2");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		l.Add(t3, "t3");
		l.Add(t4, "t4");
		l.Add(follower, "follower");
		
		// p    o  ->
		// t1 - t2 - cb1 - cb2 - t3 - t4
		t1.SetNeighbours(new Tile[] {t2});
		t2.SetNeighbours(new Tile[] {t1, cb1});
		cb1.SetCupboards(new Cupboard[] {cb2});
		cb1.SetNeighbours(new Tile[] {t2});
		cb2.SetNeighbours(new Tile[] {t3});
		cb2.SetCupboards(new Cupboard[] {cb1});
		t3.SetNeighbours(new Tile[] {cb2, t4});
		t4.SetNeighbours(new Tile[] {t3});
		
		t1.Add(follower);
		t2.Add(o);
		
		o.Grab(follower);
		
		Logger.breakLine();
	}
	
	private void run() {
		cb1.Accept(o);
		o.Move(t3);
		o.Move(t4);
	}

	@Override
	public void execute() {
		init();
		run();
	}

}
