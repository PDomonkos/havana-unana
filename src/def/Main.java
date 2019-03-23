package def;
import java.util.HashMap;
import java.util.Scanner;

import scenario.*;

public class Main {
	public static Scanner in;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		//k�l�n printline-ba szedve �tl�that�bb szerintem
		System.out.println("Havana Beach Skeleton\n");
		System.out.println("1.1: Panda �res mez�re mozog");
		System.out.println("1.2: Panda foglalt mez�re mozog");
		System.out.println("2: Pand�t t�r�keny csemp�re h�znak, mik�zben � is h�z egy pand�t.");
		System.out.println("3: Or�ngut�n t�r�keny csemp�re l�p �s lezuhan");
		System.out.println("4: �hes panda csilingel�s hat�s�ra ugrik egyet");
		System.out.println("5: Lusta panda le�l");
		System.out.println("6: Or�ngut�n megfog egy pand�t, mik�zben h�z egyet");
		System.out.println("7: Or�ngut�n l�p, mik�zben h�z egy pand�t");
		System.out.println("8: Or�ngut�n �th�z egy Pand�t egy Cupboardon kereszt�l");
		System.out.println("9: Or�ngut�n kivisz egy Pand�t a kij�raton");
		System.out.println("10: Ijed�s Panda megijed �s elengedi a m�g�tte �ll� kez�t");
		
		System.out.print("V�lassz men�pontot: ");
		String input = in.nextLine();
		
		// Scenariok betoltese a map-be
		HashMap<String, Scenario> Scenarios = new HashMap<String, Scenario>();
		Scenarios.put("1.1", new PandaSteps_1_1());
		Scenarios.put("1.2", new PandaSteps_1_2());
		Scenarios.put("2", new PandaToWeakTile_2());
		Scenarios.put("3", new Orangutan_falls_3());
		
		// static_logger inicializ�l�sa
		Logger.init_static_logger();
				
		// Scenario kivalasztasa es futtatasa
		Scenario selected = Scenarios.get(input);
		selected.execute();
		
		
		in.close();
	}
}
