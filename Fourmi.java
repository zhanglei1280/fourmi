import java.util.Random;

public class Fourmi {

	private int depart;
	private boolean[] arete_arrive;
	// parcours de la fourmi
	private int[] parcours;

	private listArete list_arete;
	private listDistance list_distance;

	private final int Q = 1;
	private final double C = 0.7;

	public Fourmi(int depart, listArete list_arete, listDistance list_distance) {

		this.list_arete = list_arete;
		this.list_distance = list_distance;

		this.depart = depart;
		this.arete_arrive = new boolean[list_arete.obtenir_total() + 1];
		arete_arrive[depart] = true;
		this.parcours = new int[list_arete.obtenir_total() + 1];
		parcours[1] = depart;

	}

	public double TP(int p1, int p2) {
		int arete1 = p1 < p2 ? p1 : p2;
		int arete2 = p1 > p2 ? p1 : p2;
		double distance = list_distance.distance(arete1, arete2);
		return ((int) (Q / distance * 1000)) / 1000.0;
	}

	// obtenir l'arete où la fourmi est maintenant
	public int est_ou() {
		// initialiser : depart
		int ici = parcours[1];

		for (int i = 2; i < parcours.length; i++) {
			if (!(parcours[i] == 0)) {
				ici = parcours[i];
			} else {
				break;
			}
		}
		return ici;
	}

	// obtenir les probabilités de chaque arete non arrivée
	public double[] pro_suivant() {
		double[] res = new double[parcours.length];
		double QP;
		double numerateur;
		double denominate = 0;
		for (int i = 1; i < arete_arrive.length; i++) {
			if (arete_arrive[i] == false) {
				QP = list_distance.epaisseur(est_ou(), i);
				numerateur = QP / list_distance.distance(est_ou(), i);
				denominate += numerateur;
				res[i] = numerateur;

				// test--------------------------------
				// System.out.println("res[" + i + "]=" + QP + "/" +
				// list_distance.distance(est_ou(), i) + "=" + res[i]);
				// System.out.println("denominate = " + denominate);
				// end test----------------------------
			}
		}
		for (int i = 1; i < res.length; i++) {
			if (arete_arrive[i] == false) {
				// System.out.println("res[" + i + "]=" + res[i]);
				// System.out.println("res[" + i + "]/denominate" + "=" + res[i]+"/" +
				// denominate +"="+ (int)res[i] / denominate);
				res[i] = ((int) (res[i] / denominate * 1000)) / 1000.0;

				// test------------------------
				// System.out.println("res[" + i + "]=" + res[i]);
				// end test--------------------
			}
		}

		// test print list de la probabilité--------------------------------------
		// System.out.println("---List da la probabilité---");
		// for (int i = 1; i < res.length; i++) {
		// System.out.print("| " + i + " ");
		// }
		// System.out.print("|\n|");
		// for (int i = 1; i < res.length; i++) {
		// if (res[i] == 0)
		// System.out.print(" - ");
		// else
		// System.out.printf("%.3f", res[i]);
		// System.out.print("|");
		// }
		// System.out.println("\n-------------End------------\n");
		// end test--------------------------------------------------------------

		return res;
	}

	// choisir ville suivante
	public int choisir_suivant(double[] list_pro) {
		double somme = 0.0;
		for (int i = 1; i < list_pro.length; i++) {
			somme += list_pro[i];
		}

		// test------------------------------------
		// System.out.println("somme = " + somme);
		// end test--------------------------------

		// ici intervient l'aspect aléatoire
		double random = (Math.random() * somme);

		// test------------------------------------
		// System.out.println("random = " + random);
		// end test--------------------------------

		double tmp = 0;
		int i;
		for (i = 1; i < list_pro.length; i++) {
			tmp += list_pro[i];
			if (random <= tmp)
				break;
		}
		return i;
	}

	// ajouter 1 arete au parcours courant
	public void march(int arete) {
		arete_arrive[arete] = true;
		for (int i = 1; i < parcours.length; i++) {
			if (parcours[i] == 0) {
				parcours[i] = arete;
				break;
			}
		}
	}

	public boolean parcours_complete() {
		for (int i = 1; i < arete_arrive.length; i++) {
			if (arete_arrive[i] == false)
				return false;
		}
		return true;
	}

	public int[] parcours() {
		return parcours;
	}

	public double partir() {
		double cycle = 0;
		int p1,p2;
//		int arete_suivant;
		p1 = depart;
		while (!parcours_complete()) {
			p2 = choisir_suivant(pro_suivant());
			march(p2);
			cycle += list_distance.distance(p1,p2);
		}
		return ((int)(cycle*1000))/1000.0;
	}

	public void init_areteArrive() {
		for (int i = 1; i < arete_arrive.length; i++) {
			if (i != depart)
				arete_arrive[i] = false;
		}
	}

	public void init_parcours() {
		for (int i = 2; i < parcours.length; i++) {
			parcours[i] = 0;
		}
	}

	public double repartir() {
		init_areteArrive();
		init_parcours();
		return partir();
	}

	public void print() {

		System.out.println("--------Fourmi--------");
//		 System.out.println("Arete arrivée : ");
//		 for (int i = 1; i < arete_arrive.length; i++) {
//		 System.out.println("Arete" + i + " : " + arete_arrive[i]);
//		 }
		System.out.print("Parcours : ");
		for (int i = 1; i < parcours.length; i++) {
			if (!(parcours[i] == 0)) {
				System.out.print(parcours[i]);
				if (i < parcours.length - 1)
					System.out.print(" --> ");
				else
					System.out.println();
			} else {
				System.out.println();
				break;
			}
		}
		System.out.println("----------End----------");

	}

}
