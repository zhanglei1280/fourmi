import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class partirListener implements ActionListener {

	private listArete list_arete;
	private listDistance list_distance;
	private Fenetre f;
	private Colonie Col;

	public partirListener(listArete list_arete, listDistance list_distance,Fenetre f) {
		this.list_arete = list_arete;
		this.list_distance = list_distance;
		this.f = f;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Col = new Colonie(list_arete,list_distance);
		f.setCol(Col);
		Col.repartir();
	}

}
