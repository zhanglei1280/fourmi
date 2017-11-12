import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemettreListener  implements ActionListener {

	private listVille list_ville;
	private listDistance list_distance;
	private Formi_Canvas FC;
	
	public RemettreListener(listVille list_ville, listDistance list_distance,Formi_Canvas FC) {
		this.list_ville = list_ville;
		this.list_distance = list_distance;
		this.FC = FC;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_ville.remettre();
		list_distance.remettre();
		FC.repaint();
	}
}
