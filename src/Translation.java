/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: Translation.java
Date créé: 2015-07-08
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-08
*******************************************************/ 
import java.awt.Dimension;


public class Translation implements Command {
	private int witdh;
	private int height;
	private ImagePanel panel;
	
	/**
	 * Contructeur de la translation a effectuer
	 * @param dimension Les dimensions recu par l'observateur de la souris
	 * @param panelOrigine L'image Panel sur lequelle la translation a ete faite
	 */
	public Translation(Dimension dimension, ImagePanel panelOrigine)
	{
		witdh = dimension.width;
		height = dimension.height;
		this.panel = panelOrigine;
	}
	/**
	 * Methode pour executer la translation sur le panneau desirer
	 */
	public void execute()
	{
		this.panel.setTranslation(witdh, height);
		
	}
	/**
	 * Methode pour defaire une translation. Il suffit d'inverser les valeurs
	 */
	public void undo()
	{
		this.panel.setTranslation(-witdh, -height);
	}
}
