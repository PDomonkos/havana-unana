package def;
import java.util.HashMap;

public class Logger {
	// FONTOS: static_logger használata elõtt meg kell hívni az init_static_logger-t (beleteszem main-be)
	// Így egy fokkal szebb, mint ha global lenne az egész
	private static Logger static_logger;
	private static HashMap<Object, String> names= new HashMap<Object, String>(); //tároljuk a szükséges objektumokat
	private int activeCalls=0;
	
	//behúzza a szükséges tabulátornyi helyet a sor elején
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//átadott paraméterek összefûzése
	public static String concateParams(Object[] param, String separator) {
		if (param == null) return "";
	    String result = "";
	    if ( names.size()> 0) {
	        for (int i = 0; i < param.length; i++) {
	            result = result + names.get(param[i]);
	            if (i != param.length - 1) result = result + separator;
	        }
	    }
	    return result;
	}
	
	//amikor meghívunk egy függvényt, meghívjuk benne ezt a függvényt
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //kiírjuk a hívást
		activeCalls++; //a hierarchia szintjén növeljük
	}
	
	//amikor kilépünk egy függvénybõl, meghívjuk ezt a függvényt
	public void exit(Object obj, String func, Object[] param, String returnVal) {
		activeCalls--; //csökkentjük a hierarchia szintjét
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //kiírjuk a visszatérést
	}
	
	public void Add(Object obj, String name) {
		names.put(obj, name);
	}
	
	// Lekéri a static_logger-t
	public static Logger get_static_logger() {
		return static_logger;
	}
	
	// inicializálja a static_logger-t
	public static void init_static_logger() {
		static_logger = new Logger();
	}
	
	// "Kinullázza" a static_logger-t
	public static void clear_static_logger() {
		static_logger.names.clear();
		static_logger.activeCalls = 0;
	}
}
