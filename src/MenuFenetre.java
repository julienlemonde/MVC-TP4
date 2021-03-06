


	import java.awt.Toolkit;
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

	
	public class MenuFenetre extends JMenuBar {
		
		/**
		 * 
		 */
		private File ImageChoisi;
		private EcouteurMenu ecouteur;
		private MultipleView modelAUtiliser;
		private Backup backupToSave;
		public MenuFenetre(MultipleView model) {
			modelAUtiliser = model;
			ecouteur = new EcouteurMenu(modelAUtiliser);
			addMenuFichier();
			addMenuChoisirImage();
			
		}
		
		protected void addMenuFichier() {
			JMenu menu = new JMenu("Fichier");
			   menu.add(new JMenuItem("Ouvrir"));
	           menu.add(new JMenuItem("Sauvegarder"));
	           menu.add(new JMenuItem("Undo"));
	           menu.add(new JMenuItem("Quitter"));
	        
	       
			menu.getItem(0).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					JFileChooser popupFileChooser = new JFileChooser();
					int retrival = popupFileChooser.showSaveDialog(null);
				    if (retrival == JFileChooser.APPROVE_OPTION) {
					
				    try {
						InputStream file = new FileInputStream(popupFileChooser.getSelectedFile());
						ObjectInputStream input = new ObjectInputStream (file);
						Backup tempBackup = (Backup) input.readObject();
						input.close();
						backupToSave.getP1().copyThisPerpective(tempBackup.getP1());
						backupToSave.getP2().copyThisPerpective(tempBackup.getP2());
						modelAUtiliser.getPanel2().setTranslation(0, 0);
						modelAUtiliser.getPanel3().setTranslation(0, 0);
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
					
				    
				}
			});
			menu.getItem(1).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser popupFileChooser = new JFileChooser();
					int retrival = popupFileChooser.showSaveDialog(null);
				    if (retrival == JFileChooser.APPROVE_OPTION) {
							try {
						      OutputStream file = new FileOutputStream(popupFileChooser.getSelectedFile());
						      //OutputStream buffer = new BufferedOutputStream(file);
							  ObjectOutput output = new ObjectOutputStream(file);
							  output.writeObject(backupToSave);
							  output.close();

							  }
						    catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				    }
				}
			});
			menu.getItem(2).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionnaireCommande.getInstance().Undo();
				    
				}
			});
				
			menu.getItem(3).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				    
				}
			});
			KeyStroke strokeZ = KeyStroke.getKeyStroke(KeyEvent.VK_Z, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
			KeyStroke strokeO = KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
			KeyStroke strokeS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

			menu.getItem(0).setAccelerator(strokeO);
			menu.getItem(1).setAccelerator(strokeS);
			menu.getItem(2).setAccelerator(strokeZ);
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
		public void setModelToSave(MultipleView model){
			this.backupToSave = new Backup(model.getPanel2().getPerspective(), model.getPanel3().getPerspective());
		}
	}

