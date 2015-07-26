import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;


public class ObserverSouris implements Observer {

		private int width;
		private int height;
		private EcouteurSouris test;
		
	@Override
	/**
	 *  Methode pour faire un update apres avoir recu un une notification de la classe
	 *  EcouteurSouris
	 *  
	 */
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			if(o instanceof EcouteurSouris)
			{
				//Si l'Argument recu est de type dimension, il s'agit d'une translation
				if(arg.getClass().getName() == "java.awt.Dimension")
				{
					
					Command translation = new Translation((Dimension) arg,((EcouteurSouris) o).getImagePanel());
					GestionnaireCommande.getInstance().addCommand(translation);
					
				}
				//Si l'argument recu est de type Integer, il s'agit d'un zoom
				if(arg.getClass().getName() == "java.lang.Integer")
				{
					Command zoom = new Zoom((int) arg, ((EcouteurSouris) o).getImagePanel());
					GestionnaireCommande.getInstance().addCommand(zoom);
				}
			}
			
		
	}

	
	
}
