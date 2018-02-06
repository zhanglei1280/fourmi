
public class test {

	public static void main(String[] args) {
		Couleur couleur = null;
		TailleCube taille = null;
		//couleur.testCouleur();
		Cube cube1 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("grand"));
		Cube cube2 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("moyen"));
		Cube cube3 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("petit"));
		System.out.println(cube1.toString());
		System.out.println(cube2.toString());
		System.out.println(cube3.toString());
		
		Table table = new Table();
		

	}

}
