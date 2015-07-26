/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: EcouteurMenu.java
Date créé: 2015-07-01
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-01
*******************************************************/ 
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class EcouteurMenu extends Observable implements ActionListener{

	private File fileimg;
	private MultipleView model;
	public EcouteurMenu(MultipleView model) {
		// TODO Auto-generated constructor stub
		ObserverImage obs = new ObserverImage();
		this.model = model;
		this.addObserver(obs);
	}
	/**
	 * Methode qui est exécuté lorsque le bouton choisir image est appuyer
	 */
	public void actionPerformed(ActionEvent e) {
		
		
		//Cree un filtre pour seulement pouvoir choisir des images
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
	/**
	 * Accesseur du model
	 * @return Retourne un objet de type Model
	 */
	public MultipleView getModel()
	{
		return this.model;
	}
}
