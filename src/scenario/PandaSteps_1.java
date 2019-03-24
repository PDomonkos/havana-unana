package scenario;

import java.util.Scanner;

import animal.Panda;
import def.Logger;
import def.Main;
import tile.Tile;

// Panda foglalt mezore mozog
public class PandaSteps_1 implements Scenario {
	Panda p1, p2;
	Tile t1, t2;
	
	private void init(boolean foglalt) {
		Logger l = Logger.get_static_logger();
		
		p1 = new Panda();
		if (foglalt)
			p2 = new Panda();
		t1 = new Tile();
		t2 = new Tile();
		
		l.Add(p1, "p1");
		if (foglalt)
			l.Add(p2, "p2");
		l.Add(t1, "t1");
		l.Add(t2, "t2");
		
		t1.Add(p1);
		if (foglalt)
			t2.Add(p2);
		t1.SetNeighbours(new Tile[] {t2});
		t2.SetNeighbours(new Tile[] {t1});
	}
	
	private void run() {
		p1.Step();
	}

	@Override
	public void execute() {
		Scanner s = Main.in;
		System.out.println("Foglaltra lépjen? (I/N)");
		boolean answ = s.nextLine().equals("I");
		init(answ);
		run();
	}

}
