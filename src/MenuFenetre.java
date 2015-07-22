
	/******************************************************
	Cours:  LOG121
	Projet: Squelette du laboratoire #1
	Nom du fichier: MenuFenetre.java
	Date cr������������: 2013-05-03
	*******************************************************
	Historique des modifications
	*******************************************************
	*@author Patrice Boucher
	2013-05-03 Version initiale
	*******************************************************/  

	import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

	/**
	 * Cr������e le menu de la fen������tre de l'application������
	 */
	public class MenuFenetre extends JMenuBar {
		
		/**
		 * 
		 */
		private File ImageChoisi;
		private EcouteurMenu ecouteur;
		Backup backupToSave;
		public MenuFenetre() {
			ImageChoisi = new File("src/yosemite-2.jpg");
			ecouteur = new EcouteurMenu();
			addMenuFichier();
			addMenuChoisirImage();
		}
		
		protected void addMenuFichier() {
			JMenu menu = new JMenu("Fichier");
			   menu.add(new JMenuItem("Ouvrir"));
	           menu.add(new JMenuItem("Sauvegarder"));
	           menu.add(new JMenuItem("Quitter"));
	        
	       
			menu.getItem(0).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try {
						InputStream file = new FileInputStream("src/backup.data");
						InputStream buffer = new BufferedInputStream(file);
						ObjectInputStream input = new ObjectInputStream (buffer);
					    backupToSave = (Backup)input.readObject();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				    
				}
			});
			menu.getItem(1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
							try {
						      OutputStream file = new FileOutputStream("src/backup.data");
						      OutputStream buffer = new BufferedOutputStream(file);
							  ObjectOutput output = new ObjectOutputStream(buffer);
							  output.writeObject(backupToSave);

							  }
						    catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
				    
				}
			});
			menu.getItem(2).addActionListener(new ActionListener() {
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
		public void setModelToSave(Model model){
			this.backupToSave = new Backup(model.getPanel2().getPerspective(), model.getPanel3().getPerspective());
		}
	}

