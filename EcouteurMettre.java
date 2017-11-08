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

		f.setMettrePoint(mettre.getState());

	}

}
