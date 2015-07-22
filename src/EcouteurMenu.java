import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import javax.swing.JFileChooser;


public class EcouteurMenu extends Observable implements ActionListener{

	private File img;
	public EcouteurMenu() {
		// TODO Auto-generated constructor stub
		ObserverImage obs = new ObserverImage();
		
		this.addObserver(obs);
	}
	public void actionPerformed(ActionEvent e) {
		
		
		JFileChooser ImageAchoisir = new JFileChooser();
		int returnVal = ImageAchoisir.showOpenDialog((Component) e.getSource());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
            img = ImageAchoisir.getSelectedFile();
            setChanged();
            notifyObservers(img);
		
		}
	}

}
