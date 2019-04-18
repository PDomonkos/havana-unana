package def;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import animal.Animal;
import animal.Panda;
import tile.Tile;

public class Tester {
	
	private static Map<String, Object> objects;
	
	
	public static boolean isRandom = true;
	
	public static void execute(BufferedReader reader) {
		String line;
		try {
			line = reader.readLine();
			
			while (line != null) {
				String[] arr = line.split(" ");
				
				switch (arr[0]) {
				case "grab":
					Animal a1 = (Animal)objects.get(arr[1]);
					Animal a2 = (Animal)objects.get(arr[2]);
					a1.Grab((Panda)a2);
					break;
				case "move":
					Animal a = (Animal)objects.get(arr[1]);
					int idx = Integer.parseInt(arr[2]);
					a.SetDir(idx);
					break;
				case "stepAll":
					Game.Update();
					break;
				case "listAttributes":
					Steppable s = (Steppable)objects.get(arr[1]);
					s.ListAttributes();
					break;
				case "getPosition":
					Animal an = (Animal)objects.get(arr[1]);
					WriteOutput("%s %s MEZ�N �LL", new Object[] {an, an.getTile()});
					break;
				case "setWeakTile":
					Tile current = (Tile)objects.get(arr[1]);
					current.set_count(Integer.parseInt(arr[2]));
					break;
				case "load":
					Game.Generate(arr[1]);
					objects = Game.GetObjects();
					break;
				case "setRandom":
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void WriteOutput(String s, Object[] o) {
		ArrayList<String> stringParams=new ArrayList<String>();
		
		HashMap<Object,String> invertedObjects=invert(objects);
		
		if(o!=null) {
			for(int  i = 0; i < o.length;i++) {
				stringParams.add(invertedObjects.get(o[i]));
			}
		}
		
		StringBuilder sb=new StringBuilder();
		Formatter fr=new Formatter(sb);
		fr.format(s, stringParams.toArray());
		System.out.println(sb.toString());
		fr.close();
	}
	
	
	public static <V, K> HashMap<V, K> invert(Map<K, V> map) {
	    return (HashMap<V, K>) map.entrySet()
	              .stream()
	              .collect(Collectors.toMap(Entry::getValue, Entry::getKey));
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
