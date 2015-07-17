import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;


public class ObserverSouris implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
			if(o instanceof EcouteurSouris)
			{
				System.out.println(arg.getClass().getName());
				if(arg.getClass().getName() == "java.awt.Dimension")
				System.out.println("Il y a update" + arg);
				if(arg.getClass().getName() == "java.lang.Boolean")
					System.out.println("Scrolled");
			}
			
		
	}

	
	
}
