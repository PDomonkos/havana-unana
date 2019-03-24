package def;
import java.util.HashMap;

public class Logger {
	// FONTOS: static_logger haszn�lata el�tt meg kell h�vni az init_static_logger-t (beleteszem main-be)
	// �gy egy fokkal szebb, mint ha global lenne az eg�sz
	private static Logger static_logger;
	/**
	 * Objektumokat n�vvel azonos�t� hashmap
	 */
	private static HashMap<Object, String> names= new HashMap<Object, String>(); 
	/**
	 * H�v�si m�lys�g
	 */
	private int activeCalls=0;
	
	/**
	 * beh�zza a sz�ks�ges tabul�tornyi helyet a sor elej�n
	 */
	public void Merger() {
		for(int i=0; i<activeCalls; i++)
		System.out.print("\t");
	}
	
	/**
	 * �tadott param�terek �sszef�z�se
	 * @param param �tadott param�terek
	 * @param separator szepar�tor karakter
	 * @return param�terek neveit a szepar�torral elv�lasztva tartalmaz� sz�veg
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
	 * F�ggv�nybe l�p�skor �rja ki a h�v�st
	 * 
	 * amikor megh�vunk egy f�ggv�nyt, megh�vjuk benne ezt a f�ggv�nyt 
	 * 
	 * @param obj akin a f�ggv�nyt h�vt�k
	 * @param func f�ggv�ny neve
	 * @param param param�terek
	 */
	public void enter(Object obj, String func, Object[] param) {
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //ki�rjuk a h�v�st
		activeCalls++; //a hierarchia szintj�n n�velj�k
	}
	
	/**
	 * F�ggv�nyb�l kil�p�skor �rja ki a visszat�r�st
	 * 
	 * amikor kil�p�nk egy f�ggv�nyb�l, megh�vjuk ezt a f�ggv�nyt 
	 * 
	 * @param obj akin a f�ggv�nyt h�vt�k
	 * @param func f�ggv�ny neve
	 * @param param param�terek
	 * @param returnVal visszat�r�si �rt�k
	 */
	public void exit(Object obj, String func, Object[] param, String returnVal) {
		activeCalls--; //cs�kkentj�k a hierarchia szintj�t
		Merger(); //beh�z�s a sor elej�n
		String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
		System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //ki�rjuk a visszat�r�st
	}
	
	/**
	 * Objektum t�rol�sa a nev�vel azonos�tva
	 * 
	 * @param obj objektum
	 * @param name neve
	 */
	public void Add(Object obj, String name) {
		names.put(obj, name);
		System.out.println("> "+name+"()");
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
	
	/**
	 * sort�r�s
	 */
	public static void breakLine() {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
