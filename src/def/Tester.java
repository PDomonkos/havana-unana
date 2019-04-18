package def;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	
	public static boolean isRandom = false;
	
	public static boolean execute(BufferedReader test_reader, BufferedReader expected_reader, boolean write_out) {
		String line;
		try {
			line = test_reader.readLine();
			
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
					WriteOutput("%s %s MEZÕN ÁLL", new Object[] {an, an.getTile()});
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
					isRandom = true;
					break;
				}
				
				line = test_reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static void WriteOutput(String s, Object[] o) {
		if (o == null) {
			System.out.println(s);
		} else {
			ArrayList<String> stringParams=new ArrayList<String>();
			
			Map<Object,String> invertedObjects=invert(objects);
			
			for(int  i = 0; i < o.length;i++) {
				stringParams.add(invertedObjects.get(o[i]));
			}
			
			
			StringBuilder sb=new StringBuilder();
			Formatter fr=new Formatter(sb);
			fr.format(s, stringParams.toArray());
			System.out.println(sb.toString());
			fr.close();
		}
	}
	
	
	public static <V, K> Map<V, K> invert(Map<K, V> map) {
	    return map.entrySet()
	              .stream()
	              .collect(Collectors.toMap(Entry::getValue, Entry::getKey));
	}
}