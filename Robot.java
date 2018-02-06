
public class Robot {
	// private String nom;
	private Table table;
	private Cube cubeTenu;

	public Robot(Table table) {
		this.table = table;
	}

	// private String getNom() {
	// return this.nom;
	// }

	// private void setNom(String nom) {
	// this.nom = nom;
	// }

	private Cube getCubetenu() {
		return this.cubeTenu;
	}

	private void setCubetenu(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public void creerCube(Couleur couleur, TailleCube taille) {
		if (v�riMainVide()) {
			Cube cubeCr�� = new Cube(couleur, taille);
			setCubetenu(cubeCr��);
		}
	}

	public void tenirCube(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public boolean v�riMainVide() {
		return cubeTenu == null;
	}

	public void poserSurTable() {
		if (!v�riMainVide()) {
			table.ajouterCube(cubeTenu);
			lacher();
		}
	}

	public void lacher() {
		this.cubeTenu = null;
	}

	public void prendre(TailleCube taille, Couleur couleur) {
		if (v�riMainVide()) {
			cubeTenu = table.enl�veCube(taille, couleur);
		}
	}

	public void poserSurCube(TailleCube taille, Couleur couleur) {
		if (!v�riMainVide() && cubeTenu.poserPossible(taille) && table.mettreSurCube(taille, couleur, cubeTenu)) {
			lacher();
		}
	}

	public void detruireCube() {
		if (!v�riMainVide()) {
			this.cubeTenu = null;
			System.out.println(x);
		}
			
	}

	public void afficherRobot() {
		System.out.print("Robot ");
		if (v�riMainVide())
			System.out.println("ne tient rien.");
		else {
			System.out
					.println("tient un " + cubeTenu.getTaille().name() + " cube " + cubeTenu.getCouleur().name() + ".");
		}
	}
	// void setCubeTenu(Cube value) {
	// this.cubeTenu = value;
	// }

}
