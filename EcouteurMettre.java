import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EcouteurMettre implements ItemListener {

	private Checkbox mettre;

	private Fenetre f;

	public EcouteurMettre(Checkbox mettre,Fenetre f) {
		this.mettre = mettre;
		this.f = f;
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
//		if (mettre.getState()) {
//			System.out.println("mettre : " + mettre.getState());
//
//		}
//
//		else
//			System.out.println("mettre : " + mettre.getState());
//		mettre_point = mettre.getState();
//		System.out.println("Checkbox : " + mettre.getState());
//		System.out.println("mettre : " + f.isMettrePoint());
		f.setMettrePoint(mettre.getState());
//		System.out.println("mettre : " + f.isMettrePoint());
	}

}
