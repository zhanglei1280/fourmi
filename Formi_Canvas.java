import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Formi_Canvas extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private listArete list;

	public Formi_Canvas(listArete list) {

		this.list = list;

	}

	public void paint(Graphics g) {

		g.setColor(new Color(219, 208, 167));
		g.fillRect(10, 10, 800, 800);

		g.setColor(Color.BLACK);
		for (int i = 1; i <= list.obtenir_total(); i++) {
			g.fillOval(list.obtenir_X(i) - 5, list.obtenir_Y(i) - 5, 10, 10);
		}

	}

}