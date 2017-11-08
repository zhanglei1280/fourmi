import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class listDistanceListener implements ActionListener {
	
	private listDistance list_distance;
	
	public listDistanceListener(listDistance list_distance) {
		this.list_distance = list_distance;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		list_distance.toString();
	}

}
