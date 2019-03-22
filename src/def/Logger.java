package def;
import java.util.HashMap;

public class Logger {
	// FONTOS: static_logger haszn�lata el�tt meg kell h�vni az init_static_logger-t (beleteszem main-be)
	// �gy egy fokkal szebb, mint ha global lenne az eg�sz
	private static Logger static_logger;
	private static HashMap<Object, String> names= new HashMap<Object, String>(); //t�roljuk a sz�ks�ges objektumokat
	private int activeCalls=0;
	
	//beh�zza a sz�ks�ges tabul�tornyi helyet a sor elej�n
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	//�tadott param�terek �sszef�z�se
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
	
	//amikor megh�vunk egy f�ggv�nyt, megh�vjuk benne ezt a f�ggv�nyt
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //ki�rjuk a h�v�st
		activeCalls++; //a hierarchia szintj�n n�velj�k
	}
	
	//amikor kil�p�nk egy f�ggv�nyb�l, megh�vjuk ezt a f�ggv�nyt
	public void exit(Object obj, String func, Object[] param, String returnVal) {
		activeCalls--; //cs�kkentj�k a hierarchia szintj�t
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //ki�rjuk a visszat�r�st
	}
	
	public void Add(Object obj, String name) {
		names.put(obj, name);
	}
	
	// Lek�ri a static_logger-t
	public static Logger get_static_logger() {
		return static_logger;
	}
	
	// inicializ�lja a static_logger-t
	public static void init_static_logger() {
		static_logger = new Logger();
	}
	
	// "Kinull�zza" a static_logger-t
	public static void clear_static_logger() {
		static_logger.names.clear();
		static_logger.activeCalls = 0;
	}
}
