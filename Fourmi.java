public class Fourmi {

	private int depart;
	private boolean[] arete_arrive;
	// parcours de la fourmi
	private int[] parcours;
	private double distance;

	private listVille list_ville;
	private listDistance list_distance;

	private final int Q = 1;
	private final double C = 0.7;
	//C représente la quantité de phéromone évaporée 
	//sur l'arête(i,j) durant le cycle nc.
	

	public Fourmi(int depart, listVille list_ville, listDistance list_distance) {

		this.list_ville = list_ville;
		this.list_distance = list_distance;

		this.depart = depart;
		this.arete_arrive = new boolean[list_ville.obtenir_total() + 1];
		arete_arrive[depart] = true;
		this.parcours = new int[list_ville.obtenir_total() + 1];
		parcours[1] = depart;

	}

	public double TP(int v1, int v2) {
		double distance = list_distance.distance(v1, v2);
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
			}
		}
		for (int i = 1; i < res.length; i++) {
			if (arete_arrive[i] == false) {
				res[i] = ((int) (res[i] / denominate * 1000)) / 1000.0;
			}
		}

		return res;
	}
	
	//test écrire les probabilité 
	public void print_pro(double[] res) {
		System.out.println("---List da la probabilité---");
		for (int i = 1; i < res.length; i++) {
			System.out.print("| " + i + " ");
		}
		System.out.print("|\n|");
		for (int i = 1; i < res.length; i++) {
			if (res[i] == 0)
				System.out.print(" - ");
			else
				System.out.printf("%.3f", res[i]);
			System.out.print("|");
		}
		System.out.println("\n-------------End------------\n");
	}

	// choisir ville suivante
	public int choisir_suivant(double[] list_pro) {
		double somme = 0.0;
		for (int i = 1; i < list_pro.length; i++) {
			somme += list_pro[i];
		}

		// ici intervient l'aspect aléatoire
		double random = (Math.random() * somme);

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

	public int[] obtenir_parcours() {
		return parcours;
	}
	
	public double obtenir_distrance() {
		return distance;
	}
	

	public void partir() {
		distance = 0;
		int p1,p2;

		p1 = depart;
		while (!parcours_complete()) {
			p2 = choisir_suivant(pro_suivant());
			march(p2);
			distance += list_distance.distance(p1,p2);
		}
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

	public void repartir() {
		init_areteArrive();
		init_parcours();
	}

	public void print() {

		System.out.println("--------Fourmi--------");
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
