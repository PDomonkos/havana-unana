package def;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Tester {
	private static Map<Object, String> objects = new HashMap<Object, String>();
	
	public static void execute(BufferedReader reader) {
		String line;
		try {
			line = reader.readLine();
			
			while (line != null) {
				String[] arr = line.split(" ");
				
				switch (arr[0]) {
				case "grab":
					break;
				case "move":
					break;
				case "create":
					switch (arr[1]) {
					case "Orangutan":
						break;
					case "LazyPanda":
						break;
					case "ShyPanda":
						break;
					case "HungryPanda":
						break;
					}
					break;
				case "stepAll":
					break;
				case "listAttributes":
					break;
				case "setWeakTile":
					break;
				case "load":
					break;
				case "setRandom":
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



//
///**
// * Objektumokat n�vvel azonos�t� hashmap
// */
//private static HashMap<Object, String> names= new HashMap<Object, String>(); 
///**
// * H�v�si m�lys�g
// */
//private staticint activeCalls=0;
//
//
///**
// * �tadott param�terek �sszef�z�se
// * @param param �tadott param�terek
// * @param separator szepar�tor karakter
// * @return param�terek neveit a szepar�torral elv�lasztva tartalmaz� sz�veg
// */
//public static String concateParams(Object[] param, String separator) {
//	if (param == null) return "";
//    String result = "";
//    if ( names.size()> 0) {
//        for (int i = 0; i < param.length; i++) {
//            result = result + names.get(param[i]);
//            if (i != param.length - 1) result = result + separator;
//        }
//    }
//    return result;
//}
//
///**
// * F�ggv�nybe l�p�skor �rja ki a h�v�st
// * 
// * amikor megh�vunk egy f�ggv�nyt, megh�vjuk benne ezt a f�ggv�nyt 
// * 
// * @param obj akin a f�ggv�nyt h�vt�k
// * @param func f�ggv�ny neve
// * @param param param�terek
// */
//public static void enter(Object obj, String func, Object[] param) {
//	Merger(); //beh�z�s a sor elej�n
//	String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
//	System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //ki�rjuk a h�v�st
//	activeCalls++; //a hierarchia szintj�n n�velj�k
//}
//
///**
// * F�ggv�nyb�l kil�p�skor �rja ki a visszat�r�st
// * 
// * amikor kil�p�nk egy f�ggv�nyb�l, megh�vjuk ezt a f�ggv�nyt 
// * 
// * @param obj akin a f�ggv�nyt h�vt�k
// * @param func f�ggv�ny neve
// * @param param param�terek
// * @param returnVal visszat�r�si �rt�k
// */
//public static void exit(Object obj, String func, Object[] param, String returnVal) {
//	activeCalls--; //cs�kkentj�k a hierarchia szintj�t
//	Merger(); //beh�z�s a sor elej�n
//	String cParams=concateParams(param, ","); // az �tadott param�terek �sszef�z�se, vessz�vel elv�lasztva
//	System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //ki�rjuk a visszat�r�st
//}
//
///**
// * Objektum t�rol�sa a nev�vel azonos�tva
// * 
// * @param obj objektum
// * @param name neve
// */
//public static void Add(Object obj, String name) {
//	names.put(obj, name);
//	System.out.println("> "+name+"()");
//}
