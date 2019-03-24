package scenario;

import animal.*;
import def.Logger;
import tile.Tile;

public class Orangutan_steps_7 implements Scenario{

	private Orangutan o;
	private Tile t1, t2, t3;
	private Panda follower;
	
	private void init() {
		Logger l = Logger.get_static_logger();
		Logger.breakLine();
		
		o=new Orangutan();
		follower = new Panda();
		t1 = new Tile();
		t2 = new Tile();
		t3 = new Tile();
		
		l.Add(follower, "follower");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		l.Add(t3, "myT");
		l.Add(o, "o");
		
		t1.Add(o);
		t3.Add(follower);

		t1.SetNeighbours(new Tile[] {t2,t3});
		t2.SetNeighbours(new Tile[] {t1, t3});
		t3.SetNeighbours(new Tile[] {t1, t2});
		o.Grab(follower);
		
		Logger.breakLine();
	}
	
	private void run() {
		o.Step();
	}
	
	public void execute() {
		this.init();
		this.run();
	}
}