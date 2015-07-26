/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: ObserverImage.java
Date créé: 2015-07-05
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-05
*******************************************************/ 
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;




public class ObserverImage implements Observer{

	@Override
	/**
	 * Methode pour faire un update apres avoir recu un une notification de la classe
	 * ecouteurMenu
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		try {
			((EcouteurMenu)o).getModel().setImg(new Image((File) arg));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	

}
