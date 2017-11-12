import java.util.HashMap;
import java.util.Iterator;

public class listVille {

	//une list des ville
	//key : nom du ville
	//value : position du ville
	private HashMap<String, int[]> list_ville;
	
	//partie1 du nom d'ville
	private final String nom_1 = "Ville";
	//partie2 du nom d'ville = nombre total des villes
	private int nom_2 = 0;
	//un chaine de caractere qui est le nom suivant quand on ajouter un nouveau position
	String nom_suivant;

	public listVille() {
		list_ville = new HashMap<String, int[]>();
	}

	//regrouper un nouveau nom d'ville
	public void nom_suivant() {
		nom_suivant = nom_1 + String.valueOf(++nom_2);
	}

	//inserer un nouveau position
	public void ajouter(int[] position) {
		nom_suivant();
		list_ville.put(nom_suivant, position);

	}

	//obtenir le X de arete
	public int obtenir_X(int arete) {
		return list_ville.get(nom_1 + String.valueOf(arete))[0];
	}
	//obtenir le Y de arete
	public int obtenir_Y(int arete) {
		return list_ville.get(nom_1 + String.valueOf(arete))[1];
	}
	//obtenir le position de arete
	public int[] obtenir_p(int arete) {
		return list_ville.get(nom_1 + String.valueOf(arete));
	}

	//obtenir le nombre total d'arrret
	public int obtenir_total() {
		return nom_2 ;
	}
	
	//init le list
	public void remettre() {
		list_ville = new HashMap<String, int[]>();
		nom_2 = 0;
	}

	public String print_position(int[] position) {
		return "[" + String.valueOf(position[0]) + "," + String.valueOf(position[1]) + "]";
	}

	public String toString() {
		System.out.println("-----listArete-----");
		Iterator<String> iterator = list_ville.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " => " + print_position(list_ville.get(key)));
		}
		System.out.println("--------END--------\n");
		return null;
	}

}
