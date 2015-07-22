

	/******************************************************
	Cours:  LOG121
	Projet: Squelette du laboratoire #1
	Nom du fichier: FenetrePrincipale.java
	Date cr����: 2013-05-03
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
	 * Cette classe repr��sente la fen��tre principale de l'application 
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
			
			/*Image ImageAMontrer = new Image(menu.getImageChoisi());
			ImagePanel imgpanel = new ImagePanel(ImageAMontrer,false);
			ImagePanel imgpanel2 = new ImagePanel(ImageAMontrer,true);
			ImagePanel imgpanel3 = new ImagePanel(ImageAMontrer, true);*/
			Model newModel = new Model(new Image(new File("src/yosemite-2.jpg")));
			
			
			this.setLayout(new BorderLayout());
			this.add(menu,BorderLayout.NORTH);
			/*this.add(imgpanel,BorderLayout.WEST);
			this.add(imgpanel2,BorderLayout.CENTER);
			this.add(imgpanel3,BorderLayout.EAST);*/
			this.add(newModel.getPanel1(),BorderLayout.WEST);
			this.add(newModel.getPanel2(),BorderLayout.CENTER);
			this.add(newModel.getPanel3(),BorderLayout.EAST);
			
			this.pack();
			this.setVisible(true); // Rend la fen��tre principale visible.
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... �� r��viser selon le comportement que vous d��sirez ...
		}

	}
	