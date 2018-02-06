
public class Cube {
	private Couleur couleur;
	private TailleCube taille;
	// private int numéro;
	private Cube cubeDessous;
	
	private final String str_grand = "+---+\n|___|";
	private final String str_moyen = "+--+\n|__|";
	private final String str_petit = "+-+\n|_|";

	public Cube(Couleur couleur, TailleCube taille) {
		this.couleur = couleur;
		this.taille = taille;
	}

	public Couleur getCouleur() {
		return this.couleur;
	}

	public boolean coorespondant(TailleCube taille, Couleur couleur) {
		return this.taille == taille && this.couleur == couleur;
	}

	public void couperLienDessous() {
		this.cubeDessous = null;
	}

	public boolean poserPossible(TailleCube taille) {
		return this.taille.ordinal() >= taille.ordinal();
	}

	public void créerLienDessous(Cube cubeDessous) {
		this.cubeDessous = cubeDessous;
	}

	public Cube getCubeDessous() {
		return this.cubeDessous;
	}

	public void setCubeDessous(Cube value) {
		this.cubeDessous = value;
	}

	public TailleCube getTaille() {
		return this.taille;
	}

	public String toString() {
		String strCube;
		if (taille.ordinal() == 0)
			strCube = str_grand + taille.name() + " " + couleur.name();
		else if(taille.ordinal() == 1)
			strCube = str_moyen + taille.name() + " " + couleur.name();
		else
			strCube = str_petit + taille.name() + " " + couleur.name();
		String strCubeDessous = (cubeDessous != null) ? cubeDessous.toString() : "";
		return strCube + strCubeDessous;

	}

}
