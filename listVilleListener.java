import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listVilleListener implements ActionListener {
	
	private listVille list_ville;
	
	public listVilleListener(listVille list_ville) {
		this.list_ville = list_ville;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_ville.toString();

	}

}

