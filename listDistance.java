import java.util.HashMap;
import java.util.Iterator;

public class listDistance {

	// String nom : Arete1 entre Arete2
	// double[] : {distance , epaisseur}
	private HashMap<String, double[]> list_distance;
	private listVille list_ville;
	// private int nb_Arete;
	// String nom;
	double distance;
	double epaisseur;

	private final int Q = 1;
	private final double C = 0.7;

	public listDistance(listVille list_ville) {

		this.list_distance = new HashMap<String, double[]>();
		this.list_ville = list_ville;
	}

	public String nom(int p1, int p2) {
		return "Arete(" + String.valueOf(p1) + "," + String.valueOf(p2) + ")";
	}

	//quand on ajouter une nouvelle ville,
	//on calcule et ajoute les distance entre cette nouvelle et les anciennes
	public void ajouter(int position) {
		if (position > 1) {
			epaisseur = 1.0;
			for (int i = 1; i < list_ville.obtenir_total(); i++) {
				distance = calcule_distance(i, position);
				list_distance.put(nom(i, position), new double[] { distance, epaisseur });
			}
		}
	}

	public double calcule_distance(int v1, int v2) {
		int x1 = list_ville.obtenir_X(v1);
		int x2 = list_ville.obtenir_X(v2);
		int y1 = list_ville.obtenir_Y(v1);
		int y2 = list_ville.obtenir_Y(v2);
		double res = Math.sqrt(Math.abs((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
		return ((int) (res * 1000)) / 1000.0;
	}

	public double distance(int p1, int p2) {
		return list_distance.get(nom(p1,p2))[0];
	}

	public double epaisseur(int p1, int p2) {
		return list_distance.get(nom(p1, p2))[1];
	}

	public void remettre() {
		this.list_distance = new HashMap<String, double[]>();
	}

	// *C evapolation de
	public void evaporer() {
		Iterator<String> iterator = list_distance.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			list_distance.get(key)[1] = list_distance.get(key)[1] * C;
		}
	}

	public void gestion(int[][] list_parcours) {
		String key;
		double TP;
		for (int i = 1; i < list_parcours.length; i++) {
			for (int j = 1; j < list_parcours[i].length; j++) {
				key = nom(i - 1, i);
				TP = ((int) (Q / list_distance.get(key)[0]) * 1000) / 1000.0;
				list_distance.get(key)[1] += TP;
				
			}
		}
	}

	public String toString() {
		System.out.println("--------listDistance--------");
		Iterator<String> iterator = list_distance.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " => distance:" + list_distance.get(key)[0]);
			System.out.println("           => epaisseur:" + list_distance.get(key)[1]);
		}
		System.out.println("-------------END------------\n");
		return null;
	}

}
