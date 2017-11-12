import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Formi_Canvas extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private listVille list_ville;

	public Formi_Canvas(listVille list_ville) {

		this.list_ville = list_ville;

	}

	public void paint(Graphics g) {

		g.setColor(new Color(219, 208, 167));
		g.fillRect(10, 10, 800, 800);

		g.setColor(Color.BLACK);
		for (int i = 1; i <= list_ville.obtenir_total(); i++) {
			g.fillOval(list_ville.obtenir_X(i) - 4, list_ville.obtenir_Y(i) - 4, 8, 8);
			g.drawString(String.valueOf(i), list_ville.obtenir_X(i) - 3, list_ville.obtenir_Y(i) + 15);
		}

	}

}