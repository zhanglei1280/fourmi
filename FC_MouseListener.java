import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FC_MouseListener implements MouseListener {

	int x, y;
	private listVille list_ville;
	private Formi_Canvas FC;
	private listDistance list_distance;

	private Fenetre f;

	public FC_MouseListener(listVille list_ville, Formi_Canvas FC, listDistance list_distance,Fenetre f) {
		this.list_ville = list_ville;
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
				int[] position = { x, y };
				list_ville.ajouter(position);

				// calcule la distance
				list_distance.ajouter(list_ville.obtenir_total());
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
