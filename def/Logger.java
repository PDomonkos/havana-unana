package def;
import java.util.HashMap;

public class Logger {

	private static HashMap<Object, String> names= new HashMap<Object, String>(); //t�roljuk a sz�ks�ges objektumokat
	private int activeCalls=0;
	
	//beh�zza a sz�ks�ges tabul�tornyi helyet a sor elej�n
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//�tadott param�terek �sszef�z�se
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
	
	//amikor megh�vunk egy f�ggv�nyt, megh�vjuk benne ezt a f�ggv�nyt
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println(obj + "." + func + "("+ cParams + ")"); //ki�rjuk a h�v�st
		activeCalls++; //a hierarchia szintj�n n�velj�k
	}
	
	//amikor kil�p�nk egy f�ggv�nyb�l, megh�vjuk ezt a f�ggv�nyt
	public void exit(String obj, String func, Object[] param, String returnVal) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println(obj + "." + func + "("+ cParams + "): " + returnVal); //ki�rjuk a visszat�r�st
		activeCalls--; //cs�kkentj�k a hierarchia szintj�t
	}
	
	public void Add(Object obj, String name) {
		names.put(obj, name);
		}
}
