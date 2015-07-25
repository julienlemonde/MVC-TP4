import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class EcouteurMenu extends Observable implements ActionListener{

	private File fileimg;
	private Model model;
	public EcouteurMenu(Model model) {
		// TODO Auto-generated constructor stub
		ObserverImage obs = new ObserverImage();
		this.model = model;
		this.addObserver(obs);
	}
	public void actionPerformed(ActionEvent e) {
		
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		JFileChooser ImageAchoisir = new JFileChooser();
		ImageAchoisir.setFileFilter(filter);
		int returnVal = ImageAchoisir.showOpenDialog((Component) e.getSource());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileimg = ImageAchoisir.getSelectedFile();
            
            setChanged();
            notifyObservers(fileimg);
		
		}
	}
	public Model getModel()
	{
		return this.model;
	}
}
