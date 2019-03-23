package scenario;

import animal.*;
import def.Logger;
import tile.Tile;

public class Orangutan_grabs_6 implements Scenario{

	private Orangutan o;
	private Tile myT, t1, t2;
	private Panda p, p2;
	
	private void init() {
		Logger l = Logger.get_static_logger();
		
		o=new Orangutan();
		p = new Panda();
		p2 = new Panda();
		t1 = new Tile();
		t2 = new Tile();
		myT = new Tile();
		
		l.Add(p, "p");
		l.Add(p2, "p2");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		l.Add(myT, "myT");
		l.Add(o, "o");
		
		myT.Add(o);
		t1.Add(p);
		t2.Add(p2);
		myT.SetNeighbours(new Tile[] {t1,t2});
		t1.SetNeighbours(new Tile[] {t2, myT});
		t2.SetNeighbours(new Tile[] {t1, myT});
		p.Grab(p2);
	}
	
	private void run() {
		t1.Accept(o);
	}
	
	public void execute() {
		this.init();
		this.run();
	}
}