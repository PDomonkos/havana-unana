package scenario;

import java.util.Scanner;

import animal.Panda;
import def.Logger;
import def.Main;
import tile.Tile;
import tile.WeakTile;

public class PandaToWeakTile_2 implements Scenario {
	Panda p, follower;
	Tile t0, t1;
	WeakTile wt;
	
	private void init(boolean eltorjon_e) {
		Logger l = Logger.get_static_logger();
		Logger.breakLine();
		
		p = new Panda();
		follower = new Panda();
		t0 = new Tile();
		t1 = new Tile();
		wt = new WeakTile();
		
		if (eltorjon_e)
			wt.set_count(1);
		
		l.Add(p, "p");
		l.Add(follower, "follower");
		l.Add(t0, "t0");
		l.Add(t1, "t1");
		l.Add(wt, "wt");
		
		p.Grab(follower);
		t0.Add(follower);
		t1.Add(p);
		
		t0.SetNeighbours(new Tile[] {t1});
		wt.SetNeighbours(new Tile[] {t1});
		t1.SetNeighbours(new Tile[] {t0, wt});
		
		Logger.breakLine();
	}
	
	private void run() {
		p.Move(wt);
	}

	@Override
	public void execute() {
		Scanner s = Main.in;
		System.out.println("Eltörjön a csempe? (I/N)");
		boolean answ = s.nextLine().equals("I");
		init(answ);
		run();
	}

}
