
public class Colonie {

	private Fourmi[] listFourmi;
	private int[][] list_parcours;

	public Colonie(listArete list_arete, listDistance list_distance) {

		listFourmi = new Fourmi[list_arete.obtenir_total() + 1];
		for (int i = 1; i <= list_arete.obtenir_total(); i++) {
			listFourmi[i] = new Fourmi(i, list_arete, list_distance);
		}

		list_parcours = new int[listFourmi.length][list_arete.obtenir_total() + 1];
	}

	public void go_fourmi() {

		double cycle;
		for (int i = 1; i < listFourmi.length; i++) {
			cycle = listFourmi[i].partir();
			list_parcours[i] = listFourmi[i].parcours();
			listFourmi[i].print();
			System.out.println("cycle : " + cycle + "\n");
		}
	}
	
	public void repartir() {
		double min_cycle=listFourmi[1].repartir();
		double cycle;
		for (int i = 1; i < listFourmi.length; i++) {
			cycle =listFourmi[i].repartir();
			list_parcours[i] = listFourmi[i].parcours();
//			listFourmi[i].print();
//			System.out.println("cycle : " + cycle + "\n");
			min_cycle = min_cycle<cycle?min_cycle:cycle;
		}
		System.out.println("min_cycle : " + min_cycle + "\n");
	}
}
