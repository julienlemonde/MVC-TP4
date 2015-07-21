

	/******************************************************
	Cours:  LOG121
	Projet: Squelette du laboratoire #1
	Nom du fichier: FenetrePrincipale.java
	Date créé: 2013-05-03
	*******************************************************
	Historique des modifications
	*******************************************************
	*@author Patrice Boucher
	2013-05-03 Version initiale
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
	 * Cette classe représente la fenêtre principale de l'application 
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
			
			
			MenuFenetre menu = new MenuFenetre();
			
			Image ImageAMontrer = new Image(menu.getImageChoisi());
			ImagePanel imgpanel = new ImagePanel(ImageAMontrer,false);
			ImagePanel imgpanel2 = new ImagePanel(ImageAMontrer,true);
			ImagePanel imgpanel3 = new ImagePanel(ImageAMontrer, true);
			
			this.setLayout(new BorderLayout());
			this.add(menu,BorderLayout.NORTH);
			this.add(imgpanel,BorderLayout.WEST);
			this.add(imgpanel2,BorderLayout.CENTER);
			this.add(imgpanel3,BorderLayout.EAST);
			
			this.pack();
			this.setVisible(true); // Rend la fenêtre principale visible.
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
		}

	}
	