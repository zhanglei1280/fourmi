import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class Fenetre extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int Largeur = 830;
	final static int Hauteur = 900;

	private boolean mettre_point;
	private Colonie Col;

	int x, y;

	public Fenetre() {

		listArete list_arete = new listArete();
		listDistance list_distance = new listDistance(list_arete);
		

		this.setTitle("Fourmi");
		this.setSize(Largeur, Hauteur);
		this.setBackground(new Color(250, 227, 113));
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		Formi_Canvas FC = new Formi_Canvas(list_arete);
		this.add(FC, BorderLayout.CENTER);
		setVisible(true);

		// Fermer la fenêtre
		this.addWindowListener(new WindowCloser(this));

		// add(new Button("North"), BorderLayout.NORTH);
		// add(new Button("South"), BorderLayout.SOUTH);
		// add(new Button("East"), BorderLayout.EAST);
		// add(new Button("West"), BorderLayout.WEST);
		// add(new Button("Center"), BorderLayout.CENTER);

		// Panel droite_panel = new Panel(new GridLayout(7, 1));
		// Label label = new Label("Info de la colonie : ", Label.CENTER);
		// Button colonie = new Button("Colonie");
		// droite_panel.add(label);
		// droite_panel.add(colonie);
		// this.add(droite_panel, BorderLayout.EAST);

		Panel top_panel = new Panel(new FlowLayout(FlowLayout.CENTER));
		Button listArete = new Button("listArete");
		Button listDistance = new Button("listDistance");
		mettre_point = false;
		Checkbox mettre = new Checkbox("mettre_point", mettre_point);
		Button remettre = new Button("Remettre");
		Button partir =  new Button("Partir");
		top_panel.add(listDistance);
		top_panel.add(listArete);
		top_panel.add(mettre);
		top_panel.add(remettre);
		top_panel.add(partir);
		this.add(top_panel, BorderLayout.NORTH);

		listArete.addActionListener(new listAreteListener(list_arete));
		listDistance.addActionListener(new listDistanceListener(list_arete, list_distance));
		mettre.addItemListener(new EcouteurMettre(mettre, this));
		remettre.addActionListener(new RemettreListener(list_arete, list_distance, FC));
		partir.addActionListener(new partirListener(list_arete, list_distance, this));

		FC.addMouseListener(new FC_MouseListener(list_arete, FC, list_distance, this));

	}

	public boolean isMettrePoint() {
		return mettre_point;
	}

	public void setMettrePoint(boolean b) {
		mettre_point = b;
	}
	
	public void setCol(Colonie c) {
		Col = c;
	}

}
