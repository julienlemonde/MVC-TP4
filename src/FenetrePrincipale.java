/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: FenetrePrincipal.java
Date créé: 2015-07-01
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-01
*******************************************************/   

	import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
	 
	/**
	 * Cette classe repr������sente la fen������tre principale de l'application 
	 * @author Patrice Boucher
	 * @date 2013/05/04
	 */
	
	public class FenetrePrincipale extends JFrame{
		private static final long serialVersionUID = -1210804336046370508L;

		/**
		 * Constructeur
		 * @throws IOException 
		 */
		public FenetrePrincipale() throws IOException{
			
			//Instancie un model selon une image par defaut
			MultipleView newModel = new MultipleView(new Image(new File("src/yosemite-2.jpg")));
			//Cree un nouveau menu
			MenuFenetre menu = new MenuFenetre(newModel);
			menu.setModelToSave(newModel);
			
			
			this.setLayout(new BorderLayout());
			this.add(menu,BorderLayout.NORTH);
			//Ajoute les imagePanels au Jframe
			this.add(newModel.getPanel1(),BorderLayout.WEST);
			this.add(newModel.getPanel2(),BorderLayout.CENTER);
			this.add(newModel.getPanel3(),BorderLayout.EAST);
			
			this.pack();
			this.setVisible(true); 
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	}
	