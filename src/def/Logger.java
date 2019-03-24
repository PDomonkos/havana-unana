package def;
import java.util.HashMap;

public class Logger {
	// FONTOS: static_logger használata elõtt meg kell hívni az init_static_logger-t (beleteszem main-be)
	// Így egy fokkal szebb, mint ha global lenne az egész
	private static Logger static_logger;
	/**
	 * Objektumokat névvel azonosító hashmap
	 */
	private static HashMap<Object, String> names= new HashMap<Object, String>(); 
	/**
	 * Hívási mélység
	 */
	private int activeCalls=0;
	
	/**
	 * behúzza a szükséges tabulátornyi helyet a sor elején
	 */
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	/**
	 * átadott paraméterek összefûzése
	 * @param param átadott paraméterek
	 * @param separator szeparátor karakter
	 * @return paraméterek neveit a szeparátorral elválasztva tartalmazó szöveg
	 */
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
	
	/**
	 * Függvénybe lépéskor írja ki a hívást
	 * 
	 * amikor meghívunk egy függvényt, meghívjuk benne ezt a függvényt 
	 * 
	 * @param obj akin a függvényt hívták
	 * @param func függvény neve
	 * @param param paraméterek
	 */
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //kiírjuk a hívást
		activeCalls++; //a hierarchia szintjén növeljük
	}
	
	/**
	 * Függvénybõl kilépéskor írja ki a visszatérést
	 * 
	 * amikor kilépünk egy függvénybõl, meghívjuk ezt a függvényt 
	 * 
	 * @param obj akin a függvényt hívták
	 * @param func függvény neve
	 * @param param paraméterek
	 * @param returnVal visszatérési érték
	 */
	public void exit(Object obj, String func, Object[] param, String returnVal) {
		activeCalls--; //csökkentjük a hierarchia szintjét
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //kiírjuk a visszatérést
	}
	
	/**
	 * Objektum tárolása a nevével azonosítva
	 * 
	 * @param obj objektum
	 * @param name neve
	 */
	public void Add(Object obj, String name) {
		names.put(obj, name);
		System.out.println("> "+name+"()");
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
	
	/**
	 * sortörés
	 */
	public static void breakLine() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
