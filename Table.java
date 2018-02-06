import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {
    private List<Cube> listCubes = new ArrayList<Cube> ();
    
    public Table() {
    }

    public void ajouterCube(Cube cube) {
    	listCubes.add(cube);
    }

    public Cube rechercherCube(TailleCube taille, Couleur couleur) {
    	
    	Cube cube;
    	Iterator<Cube> it = listCubes.iterator();
    	while(it.hasNext()){
    		cube = it.next();
    	    if(cube.coorespondant(taille,couleur)) {
    	    	return cube;
    	    }    
    	}
    	return null;
    }

    public Cube enlèveCube(TailleCube taille, Couleur couleur) {
    	Cube cubeRecherche = rechercherCube(taille,couleur);
    	if (cubeRecherche != null) {
    		Cube cubeDessous = cubeRecherche.getCubeDessous();
    		if (cubeDessous != null)
    			ajouterCube(cubeDessous);
    		suppCube(cubeRecherche);
    	}
    	return cubeRecherche;
    	
    	
    }

    public void suppCube(Cube cube) {
    	listCubes.remove(cube);
    }

    public boolean mettreSurCube(TailleCube taille, Couleur couleur, Cube cubeTenu) {
    	Cube cubeRecherche = rechercherCube(taille,couleur);
    	if (cubeRecherche != null) {
    		suppCube(cubeRecherche);
    		ajouterCube(cubeTenu);
    	}
    	return cubeRecherche != null;
    }

	public void afficherTable() {
		//int size = listCubes.size();
		System.out.println("Dans la table, il y a " + listCubes.size() + " cube(s).");
		Cube cube;
		int compte = 1;
		Iterator<Cube> it = listCubes.iterator();
    	while(it.hasNext()){
    		System.out.println("cube N°" + compte + ": ");
    		cube = it.next();
    	    System.out.println(cube.toString()); 
    	}
	    
		
		
	}

}
