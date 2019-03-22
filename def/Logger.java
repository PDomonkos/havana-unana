package def;
import java.util.HashMap;

public class Logger {

	private static HashMap<Object, String> names= new HashMap<Object, String>(); //tároljuk a szükséges objektumokat
	private int activeCalls=0;
	
	//behúzza a szükséges tabulátornyi helyet a sor elején
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//átadott paraméterek összefûzése
	public static String concateParams(Object[] param, String separator) {
	       String result = "";
	    if ( names.size()> 0) {
	        result = names.get(param[0]);  
	        for (int i=1; i<names.size(); i++) {
	            result = result + separator + names.get(param[i]);
	        }
	    }
	    return result;
	}
	
	//amikor meghívunk egy függvényt, meghívjuk benne ezt a függvényt
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println(obj + "." + func + "("+ cParams + ")"); //kiírjuk a hívást
		activeCalls++; //a hierarchia szintjén növeljük
	}
	
	//amikor kilépünk egy függvénybõl, meghívjuk ezt a függvényt
	public void exit(String obj, String func, Object[] param, String returnVal) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println(obj + "." + func + "("+ cParams + "): " + returnVal); //kiírjuk a visszatérést
		activeCalls--; //csökkentjük a hierarchia szintjét
	}
	
	public void Add(Object obj, String name) {
		names.put(obj, name);
		}
}
