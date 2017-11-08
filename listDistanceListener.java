import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listDistanceListener implements ActionListener {
	
	private listArete list_arete;
	private listDistance list_distance;
	
	public listDistanceListener(listArete list_arete,listDistance list_distance) {
		this.list_arete = list_arete;
		this.list_distance = list_distance;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_distance.toString();
	}

}
