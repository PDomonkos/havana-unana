import java.util.HashMap;

public class Logger {

	private HashMap<String, Object> animals= new HashMap<String, Object>(); //tároljuk a szükséges objektumokat
	private int activeCalls=0;
	
	//behúzza a szükséges tabulátornyi helyet a sor elején
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//átadott paraméterek összefûzése
	public static String concateParams(String[] s, String separator) {
	       String result = "";
	    if (s.length > 0) {
	        result = s[0];  
	        for (int i=1; i<s.length; i++) {
	            result = result + separator + s[i];
	        }
	    }
	    return result;
	}
	
	//amikor meghívunk egy függvényt, meghívjuk benne ezt a függvényt
	public void enter(String obj, String func, String[] param) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println(obj + "." + func + "("+ cParams + ")"); //kiírjuk a hívást
		activeCalls++; //a hierarchia szintjén növeljük
	}
	
	//amikor kilépünk egy függvénybõl, meghívjuk ezt a függvényt
	public void exit(String obj, String func, String[] param, String returnVal) {
		Merger(); //behúzás a sor elején
		String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
		System.out.println(obj + "." + func + "("+ cParams + "): " + returnVal); //kiírjuk a visszatérést
		activeCalls--; //csökkentjük a hierarchia szintjét
	}
	
	public void Add(String name, Object obj) {
		animals.put(name, obj);
		}
}
