import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowCloser extends WindowAdapter {
	
	private Frame f;
	
	public WindowCloser(Frame f) {
		this.f = f;
	}
	
	// m�thod appel�e quand t'on clique sur �
		public void windowClosing(WindowEvent e) {
			// fermer la fen�tre
			f.dispose();
		}

}
