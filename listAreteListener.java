import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listAreteListener implements ActionListener {
	
	private listArete list_arete;
	
	public listAreteListener(listArete list_arete) {
		this.list_arete = list_arete;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_arete.toString();

	}

}
