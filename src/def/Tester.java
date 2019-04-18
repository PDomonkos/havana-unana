package def;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import animal.Animal;
import animal.Panda;

public class Tester {
	private static Map<String, Object> objects;
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
				case "setWeakTile":
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
		
	}
	/*
	public static <V, K> Map<V, K> invert(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .collect(Collectors.toMap(Entry::getValue, Entry::getKey));
	}**/
}



//
///**
// * Objektumokat névvel azonosító hashmap
// */
//private static HashMap<Object, String> names= new HashMap<Object, String>(); 
///**
// * Hívási mélység
// */
//private staticint activeCalls=0;
//
//
///**
// * átadott paraméterek összefûzése
// * @param param átadott paraméterek
// * @param separator szeparátor karakter
// * @return paraméterek neveit a szeparátorral elválasztva tartalmazó szöveg
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
// * Függvénybe lépéskor írja ki a hívást
// * 
// * amikor meghívunk egy függvényt, meghívjuk benne ezt a függvényt 
// * 
// * @param obj akin a függvényt hívták
// * @param func függvény neve
// * @param param paraméterek
// */
//public static void enter(Object obj, String func, Object[] param) {
//	Merger(); //behúzás a sor elején
//	String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
//	System.out.println("> " + names.get(obj) + "." + func + "("+ cParams + ")"); //kiírjuk a hívást
//	activeCalls++; //a hierarchia szintjén növeljük
//}
//
///**
// * Függvénybõl kilépéskor írja ki a visszatérést
// * 
// * amikor kilépünk egy függvénybõl, meghívjuk ezt a függvényt 
// * 
// * @param obj akin a függvényt hívták
// * @param func függvény neve
// * @param param paraméterek
// * @param returnVal visszatérési érték
// */
//public static void exit(Object obj, String func, Object[] param, String returnVal) {
//	activeCalls--; //csökkentjük a hierarchia szintjét
//	Merger(); //behúzás a sor elején
//	String cParams=concateParams(param, ","); // az átadott paraméterek összefûzése, vesszõvel elválasztva
//	System.out.println("< " + names.get(obj) + "." + func + "("+ cParams + "): " + returnVal); //kiírjuk a visszatérést
//}
//
///**
// * Objektum tárolása a nevével azonosítva
// * 
// * @param obj objektum
// * @param name neve
// */
//public static void Add(Object obj, String name) {
//	names.put(obj, name);
//	System.out.println("> "+name+"()");
//}
