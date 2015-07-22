
	/******************************************************
	Cours:  LOG121
	Projet: Squelette du laboratoire #1
	Nom du fichier: MenuFenetre.java
	Date cr����: 2013-05-03
	*******************************************************
	Historique des modifications
	*******************************************************
	*@author Patrice Boucher
	2013-05-03 Version initiale
	*******************************************************/  

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

	/**
	 * Cr��e le menu de la fen��tre de l'application��
	 */
	public class MenuFenetre extends JMenuBar {
		
		/**
		 * 
		 */
		private File ImageChoisi;
		private EcouteurMenu ecouteur;
		public MenuFenetre() {
			ImageChoisi = new File("src/yosemite-2.jpg");
			ecouteur = new EcouteurMenu();
			addMenuFichier();
			addMenuChoisirImage();
		}
		
		protected void addMenuFichier() {
			JMenu menu = new JMenu("Fichier");
	       
	           menu.add(new JMenuItem("Sauvegarder"));
	           menu.add(new JMenuItem("Quitter"));
	        
	       
			menu.getItem(0).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				    
				}
			});
			menu.getItem(1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				    
				}
			});
			add(menu);
		}
		protected void addMenuChoisirImage() {
			final JMenuItem menu = new JMenuItem("ChoisirImage");
	       
			menu.addActionListener(ecouteur);
					
			add(menu); 
				
				    
				}
			
			
		public File getImageChoisi()
		{
			return ImageChoisi;
		}
	}

