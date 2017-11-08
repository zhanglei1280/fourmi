import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemettreListener  implements ActionListener {

	private listArete list_arete;
	private listDistance list_distance;
	private Formi_Canvas FC;
	
	public RemettreListener(listArete list_arete, listDistance list_distance,Formi_Canvas FC) {
		this.list_arete = list_arete;
		this.list_distance = list_distance;
		this.FC = FC;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_arete.remettre();
		list_distance.remettre();
		FC.repaint();
	}
}
