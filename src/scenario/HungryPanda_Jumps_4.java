package scenario;

import java.util.Scanner;

import animal.HungryPanda;
import def.Logger;
import def.Main;
import tile.Tile;
import tile.VendingMachine;
import tile.WeakTile;

public class HungryPanda_Jumps_4 implements Scenario{

	HungryPanda p;
	VendingMachine v;
	WeakTile wt;
	
	@Override
	public void execute() {
		Scanner s = Main.in;
		System.out.println("Eltörjön a csempe? (I/N)");
		boolean answ = s.nextLine().equals("I")||s.nextLine().equals("i");
		init(answ);
		run();
	}

	private void run() {
		v.Step();
	}

	private void init(boolean break_tile) {
		Logger l=Logger.get_static_logger();
		
		p=new HungryPanda();
		v=new VendingMachine();
		wt=new WeakTile();
		
		if(break_tile)wt.set_count(2);
		else wt.set_count(3);
		
		l.Add(p, "p");
		l.Add(v, "v");
		l.Add(wt, "wt");
		
		wt.Add(p);
		
		v.SetNeighbours(new Tile[] {wt});
		wt.SetNeighbours(new Tile[] {v});
		
	}
}
