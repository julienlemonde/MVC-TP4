/******************************************************
Cours:  LOG121
Session: E2015
Projet: MVC-TP4
Étudiant(e)s: Alexandre Malo, 
			  Marc-Antoine Hebert, 
			  Jean-Michel Coupal,
			  Julien Lemonde

Professeur : Francis Cardinal
Nom du fichier: MultipleView.java
Date créé: 2015-07-15
*******************************************************
@author Alexandre Malo, Marc-Antoine Hebert, Jean-Michel Coupal, Julien Lemonde
@date 2015-07-15
*******************************************************/ 
import java.io.Serializable;
import java.util.Observable;



public class MultipleView extends Observable implements Serializable{

	
	private static final long serialVersionUID = 2975882143448572952L;
	private Image img;
	private ImagePanel imgpanel;
	private ImagePanel imgpanel2;
	private ImagePanel imgpanel3;
	
	/**
	 * Constructeur de notre model
	 * @param img l'image qui sera dans tous les panels
	 */
	public MultipleView(Image img)
	{
		this.img = img;
		imgpanel = new ImagePanel(img,false);
		imgpanel2 = new ImagePanel(img,true);
		imgpanel3 = new ImagePanel(img, true);
		
	}

	/**
	 * Accesseur de l'image 
	 * @return Un objet de type image
	 */
	public Image getImg() {
		return img;
	}

	/**
	 * Mutateur de l'image dans le model, Quand on change l'image on reinitialise les
	 * perspective
	 * @param img La nouvelle image
	 */
	public void setImg(Image img) {
		this.img = img;
		imgpanel.setImage(img);
		imgpanel2.setImage(img);
		imgpanel3.setImage(img);
		setChanged();
		notifyObservers(this.img);
	}
	
	/**
	 * Accesseur du premier image panel
	 * @return Un objet du type Image Panel
	 */
	public ImagePanel getPanel1() {
		return imgpanel;
	}

	/**
	 * Accesseur du deuxieme image panel
	 * @return Un objet du type Image Panel
	 */
	public ImagePanel getPanel2(){
		return imgpanel2;
	}
	/**
	 * Accesseur du troisieme image panel
	 * @return Un objet du type Image Panel
	 */
	public ImagePanel getPanel3()
	{
		return imgpanel3;
	}
	
	
	
	
	
}
