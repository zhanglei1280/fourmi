import java.util.HashMap;
import java.util.Iterator;

public class listDistance {

	// String nom : Arete1 entre Arete2
	// double[] : {distance , epaisseur}
	private HashMap<String, double[]> list_distance;
	private listArete list_Arete;
	// private int nb_Arete;
	// String nom;
	double distance;
	double epaisseur;

	private final int Q = 1;
	private final double C = 0.7;

	public listDistance(listArete list_Arete) {

		this.list_distance = new HashMap<String, double[]>();
		this.list_Arete = list_Arete;
	}

	public String nom(int p1, int p2) {
		return "Arete(" + String.valueOf(p1) + "," + String.valueOf(p2) + ")";
	}

	public void ajouter(int position) {
		if (position > 1) {
			epaisseur = 1.0;
			for (int i = 1; i < list_Arete.obtenir_total(); i++) {

				// test------------------------------------------------
				// System.out.println("calcule" + i + "-" + position);
				//fin test---------------------------------------------

				distance = calcule_distance(list_Arete.obtenir_p(i), list_Arete.obtenir_p(position));
				list_distance.put(nom(i, position), new double[] { distance, epaisseur });
			}
		}
	}

	public double calcule_distance(int[] p1, int[] p2) {
		double res = Math.sqrt(Math.abs((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])));
		return ((int) (res * 1000)) / 1000.0;
	}

	public double distance(int p1, int p2) {
		int tmp1, tmp2;
		tmp1 = p1 < p2 ? p1 : p2;
		tmp2 = p1 > p2 ? p1 : p2;
		return list_distance.get(nom(tmp1, tmp2))[0];
	}

	public double epaisseur(int p1, int p2) {
		int tmp1, tmp2;
		tmp1 = p1 < p2 ? p1 : p2;
		tmp2 = p1 > p2 ? p1 : p2;
		return list_distance.get(nom(tmp1, tmp2))[1];
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
		System.out.println("----------listArete----------");
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
