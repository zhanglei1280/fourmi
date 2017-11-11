
public class test_un_fourmi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		listArete list_arete = new listArete();
		listDistance list_distance = new listDistance(list_arete);

		list_arete.ajouter(new int[] { 0, 0 });
		list_distance.ajouter(list_arete.obtenir_total());
		list_arete.ajouter(new int[] { 0, 2 });
		list_distance.ajouter(list_arete.obtenir_total());
		list_arete.ajouter(new int[] { 4, 0 });
		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 1, 1 });
//		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 1, 5 });
//		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 1, 7 });
//		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 2, 1 });
//		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 2, 5 });
//		list_distance.ajouter(list_arete.obtenir_total());
//		list_arete.ajouter(new int[] { 2, 7 });
//		list_distance.ajouter(list_arete.obtenir_total());

		 list_arete.toString();
		 list_distance.toString();

//		 Fourmi f = new Fourmi(1,list_arete,list_distance);
//		 f.print();
//		 f.march(f.choisir_suivant(f.pro_suivant()));
//		 f.print();
//		 int[][] list_parcours = new int[0][1];
//		 list_parcours[0] = new int[] {1,2};
		 list_distance.evaporer();
		 list_distance.toString();
		 list_distance.gestion(new int[][]{{1,2}});
		 list_distance.toString();
		// f.march(f.choisir_suivant(f.pro_suivant()));
		// f.print();
		// f.march(f.choisir_suivant(f.pro_suivant()));
		// f.print();

//		double cycle;
//		Fourmi f = new Fourmi(1, list_arete, list_distance);
//		cycle = f.partir();
//		f.print();
//		System.out.println("cycle : " + cycle + "\n");
//		cycle = f.repartir();
//		f.print();
//		System.out.println("cycle : " + cycle + "\n");

//		 Colonie Col = new Colonie(list_arete,list_distance);
//		 Col.go_fourmi();
//		 Col.repartir();

//choisir_suivant;
	}

}
