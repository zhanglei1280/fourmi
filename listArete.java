import java.util.HashMap;
import java.util.Iterator;

public class listArete {

	//une list des arete
	//key : nom du arete
	//value : position du arete
	private HashMap<String, int[]> list_arete;
	
	//partie1 du nom d'arete
	private final String nom_1 = "Arete";
	//partie2 du nom d'arete = nombre total des aretes + 1
	private int nom_2 = 1;
	//un chaine de caractere qui est le nom suivant quand on ajouter un nouveau position
	private String nom_suivant;

	public listArete() {
		list_arete = new HashMap<String, int[]>();
	}

	//regrouper un nouveau nom d'arete
	public void nom_suivant() {
		nom_suivant = nom_1 + String.valueOf(nom_2++);
	}

	//inserer un nouveau position
	public void ajouter(int[] position) {
		nom_suivant();
		list_arete.put(nom_suivant, position);

	}

	//obtenir le X de arete
	public int obtenir_X(int position) {
		return list_arete.get(nom_1 + String.valueOf(position))[0];
	}
	//obtenir le Y de arete
	public int obtenir_Y(int position) {
		return list_arete.get(nom_1 + String.valueOf(position))[1];
	}
	//obtenir le position de arete
	public int[] obtenir_p(int position) {
		return list_arete.get(nom_1 + String.valueOf(position));
	}

	//obtenir le nombre total d'arrret
	public int obtenir_total() {
		return nom_2-1 ;
	}
	
	//init le list
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
