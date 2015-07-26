/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: Zoom.java
Date créé: 2015-07-08
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-08
*******************************************************/ 
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Zoom implements Command {

	private int notchesZoom;
	private ImagePanel panel;
	/**
	 * Constructeur du zoom a effectuer
	 * @param NombreOfZoom Le nombre de zoom effectuer par la souris
	 * @param panelOrigine Le panneau sur lequel l'Action a ete faite
	 */
	public Zoom(int NombreOfZoom, ImagePanel panelOrigine)
	{
		notchesZoom = NombreOfZoom;
		this.panel = panelOrigine;
	}
	/**
	 * Methode pour executer le zoom sur le panneau
	 */
	public void execute() {
		this.panel.setScale(notchesZoom);
	}
	/**
	 * Methode pour defaire le zoom effectuer
	 */
	public void undo() {
		this.panel.setScale(-notchesZoom);
		
	}
	

}
