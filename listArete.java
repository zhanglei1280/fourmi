import java.util.HashMap;
import java.util.Iterator;

public class listArete {

	private HashMap<String, int[]> list_arete;
	private final String nom_1 = "Arete";
	private int nom_2 = 1;
	private String nom_suivant;

	public listArete() {
		list_arete = new HashMap<String, int[]>();
	}

	public void nom_suivant() {
		nom_suivant = nom_1 + String.valueOf(nom_2++);
	}

	public void ajouter(int[] position) {
		nom_suivant();
		list_arete.put(nom_suivant, position);

	}

	public int obtenir_X(int position) {
		return list_arete.get(nom_1 + String.valueOf(position))[0];
	}

	public int obtenir_Y(int position) {
		return list_arete.get(nom_1 + String.valueOf(position))[1];
	}
	
	public int[] obtenir_p(int position) {
		return list_arete.get(nom_1 + String.valueOf(position));
	}

	//obtenir le nombre total d'arrret
	public int obtenir_total() {
		return nom_2-1 ;
	}
	
	public void remettre() {
		list_arete = new HashMap<String, int[]>();
		nom_2 = 1;
	}

	public String print_position(int[] position) {
		return "[" + String.valueOf(position[0]) + "," + String.valueOf(position[1]) + "]";
	}

	public String toString() {
		System.out.println("-----listArete-----");
		Iterator<String> iterator = list_arete.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " => " + print_position(list_arete.get(key)));
		}
		System.out.println("--------END--------\n");
		return null;
	}

}
