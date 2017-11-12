import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class partirListener implements ActionListener {

	private listVille list_ville;
	private listDistance list_distance;
	private Fenetre f;
	private Colonie Col;

	public partirListener(listVille list_ville, listDistance list_distance,Fenetre f) {
		this.list_ville = list_ville;
		this.list_distance = list_distance;
		this.f = f;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Col = new Colonie(list_ville,list_distance);
		f.setCol(Col);
		Col.repartir();
	}

}
