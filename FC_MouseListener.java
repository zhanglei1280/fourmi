import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FC_MouseListener implements MouseListener {

	private int x, y;
	private listArete list_arete;
	private Formi_Canvas FC;
	private listDistance list_distance;
	
	private Fenetre f;

	public FC_MouseListener(listArete list_arete, Formi_Canvas FC, listDistance list_distance,Fenetre f) {
		this.list_arete = list_arete;
		this.FC = FC;
		this.list_distance = list_distance;
		
		this.f = f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (f.isMettrePoint()) {
			// obtenir la position
			x = e.getX();
			y = e.getY();

			// if il est valable,on le ajoute dans la base de donnee,puis calcule la
			// distance
			if (x > 10 && x < 810 && y > 10 && y < 810) {

				// pour tester
				System.out.println("click : " + x + " , " + y);
				int[] position = { x, y};
				list_arete.ajouter(position);

				// calcule la distance
				list_distance.ajouter(list_arete.obtenir_total());
			}

			FC.repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
