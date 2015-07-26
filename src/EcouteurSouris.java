/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: EcouteurSouris.java
Date créé: 2015-07-03
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-03
*******************************************************/ 
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Observable;


public class EcouteurSouris extends Observable implements MouseListener, MouseWheelListener {

	private int xPressed;
	private int yPressed;
	private int xRelease;
	private int yRelease;
	private ImagePanel panel;
	private Dimension translation;
	private int Notches;
	private boolean scrolled;
	
	/**
	 * Constructeur de l'ecouteur de souris 
	 * @param imgpanel Le panneau sur lequel l'action a ete executer
	 */
	public EcouteurSouris(ImagePanel imgpanel) {
		// TODO Auto-generated constructor stub
		ObserverSouris obs = new ObserverSouris();
		this.panel = imgpanel;
		this.addObserver(obs);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Methode pour garder en memoire l'endroit ou la souris etait dans le panneau
	 * lors click droit maintenu
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		xPressed = e.getX();
		yPressed = e.getY();
		
	}

	@Override
	/**
	 * Methode pour calculer la translation entre l'endroit de la souris d'origine et
	 * l'endroit ou la souris a ete relacher
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		xRelease = e.getX();
		yRelease = e.getY();
		translation = new Dimension(xRelease - xPressed, yRelease - yPressed);
		setChanged();
		//Notifie les observers de la classe
		notifyObservers(translation);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	/**
	 * Methode pour extraire le nombre de scroll de la souris
	 */
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
		Notches = e.getWheelRotation();
		setChanged();
		notifyObservers(Notches);
		
	}
	/**
	 * Accesseur du panneau d'image sur lequel la souris etait
	 * @return Un objet de type panneau d'image
	 */
	public ImagePanel getImagePanel()
	{
		return panel;
	}

	
}
