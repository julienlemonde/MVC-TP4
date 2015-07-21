import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;


public class ObserverSouris implements Observer {

		private int width;
		private int height;
		private EcouteurSouris test;
		
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			if(o instanceof EcouteurSouris)
			{
				
				if(arg.getClass().getName() == "java.awt.Dimension")
				{
					
					Command translation = new Translation((Dimension) arg,((EcouteurSouris) o).getImagePanel());
					GestionnaireCommande.getInstance().addCommand(translation);
					
				}
				
				if(arg.getClass().getName() == "java.lang.Integer")
				{
					Command zoom = new Zoom((int) arg, ((EcouteurSouris) o).getImagePanel());
					GestionnaireCommande.getInstance().addCommand(zoom);
				}
			}
			
		
	}

	
	
}
