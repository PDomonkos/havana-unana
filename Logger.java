import java.util.HashMap;

public class Logger {

	private HashMap<String, Object> animals= new HashMap<String, Object>(); //t�roljuk a sz�ks�ges objektumokat
	private int activeCalls=0;
	
	//beh�zza a sz�ks�ges tabul�tornyi helyet a sor elej�n
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//�tadott param�terek �sszef�z�se
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
	
	//amikor megh�vunk egy f�ggv�nyt, megh�vjuk benne ezt a f�ggv�nyt
	public void enter(String obj, String func, String[] param) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println(obj + "." + func + "("+ cParams + ")"); //ki�rjuk a h�v�st
		activeCalls++; //a hierarchia szintj�n n�velj�k
	}
	
	//amikor kil�p�nk egy f�ggv�nyb�l, megh�vjuk ezt a f�ggv�nyt
	public void exit(String obj, String func, String[] param, String returnVal) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println(obj + "." + func + "("+ cParams + "): " + returnVal); //ki�rjuk a visszat�r�st
		activeCalls--; //cs�kkentj�k a hierarchia szintj�t
	}
	
	public void Add(String name, Object obj) {
		animals.put(name, obj);
		}
}
