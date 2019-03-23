package def;
import java.util.HashMap;
import java.util.Scanner;

import scenario.*;

/**
 * Fõ osztály
 * 
 */
public class Main {
////////////ez micsoda szebi nem mutatta
	public static Scanner in;
	
	/**
	 * Menü listázása, választott szcenárió futtatása
	 * 
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {
		in = new Scanner(System.in);
				
		System.out.println("Havana Beach Skeleton\n");
		System.out.println("1.1: Panda üres mezõre mozog");
		System.out.println("1.2: Panda foglalt mezõre mozog");
		System.out.println("2: Pandát törékeny csempére húznak, miközben õ is húz egy pandát.");
		System.out.println("3: Orángután törékeny csempére lép és lezuhan");
		System.out.println("4: Éhes panda csilingelés hatására ugrik egyet");
		System.out.println("5: Lusta panda leül");
		System.out.println("6: Orángután megfog egy pandát, miközben húz egyet");
		System.out.println("7: Orángután lép, miközben húz egy pandát");
		System.out.println("8: Orángután áthúz egy Pandát egy Cupboardon keresztül");
		System.out.println("9: Orángután kivisz egy Pandát a kijáraton");
		System.out.println("10: Ijedõs Panda megijed és elengedi a mögötte álló kezét");
		
		System.out.print("Válassz menüpontot: ");
		String input = in.nextLine();
		
		// Scenariok betoltese a map-be
		HashMap<String, Scenario> Scenarios = new HashMap<String, Scenario>();
		Scenarios.put("1.1", new PandaSteps_1_1());
		Scenarios.put("1.2", new PandaSteps_1_2());
		Scenarios.put("2", new PandaToWeakTile_2());
		Scenarios.put("3", new Orangutan_falls_3());
		Scenarios.put("4", new HungryPanda_Jumps_4());
		Scenarios.put("5", new LazyPanda_sits_5());
		Scenarios.put("6", new Orangutan_grabs_6());
		Scenarios.put("7", new Orangutan_steps_7());
		Scenarios.put("8", new OrangutanPullTroughCupboard_8());
		Scenarios.put("9", new OrangutanPullTroughExit_9());
		Scenarios.put("10", new ShyPandaScaresAndLets_10());
		
		// static_logger inicializálása
		Logger.init_static_logger();
				
		// Scenario kivalasztasa es futtatasa
		Scenario selected = Scenarios.get(input);
		selected.execute();
			
		in.close();
	}
}
