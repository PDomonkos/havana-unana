package def;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Fő osztály
 * 
 */
public class Main {
	public static Scanner in;
	/**
	 * Menü listázása, választott szcenárió futtatása
	 * 
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {
		in= new Scanner(System.in);
		try {
			System.out.println("1.: Egy teszteset futtatása");
			System.out.println("2.: Összes teszteset futtatása");
			System.out.println("3.: Kézi tesztelés");
			
			String input = in.nextLine();
			switch(input) {
			case "1":
				System.out.println("Adja meg a teszteset számát (1-33)!");
				int n= Integer.parseInt(in.nextLine());
				if(0<n && n<34) {
					FileReader fr1 = new FileReader("test"+n+"_input.txt");
					BufferedReader br1 = new BufferedReader(fr1);
					FileReader fr2 = new FileReader("test"+n+"_output.txt");
					BufferedReader br2 = new BufferedReader(fr2);
					boolean success = Tester.execute(br1,br2,true);
					if (success) System.out.println("Sikeres!");
					else System.out.println("Sikertelen");
				}
				else
					System.out.println("Hibás szám");
				break;
			case "2":
				int suc=0;
				for(n = 1; n <= 33; n++) {
					FileReader fr1 = new FileReader("test" + n + "_input.txt");
					BufferedReader br1 = new BufferedReader(fr1);
					FileReader fr2 = new FileReader("test"+n + "_output.txt");
					BufferedReader br2 = new BufferedReader(fr2);
					boolean success = Tester.execute(br1,br2,false);
					if (success) suc++;
				}
				System.out.println("A 33 tesztből" + suc + "Sikeres");
				break;
			case "3":
		
				break;
			default:
				System.out.println("Érvénytelen parancs");
			}
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}