import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;




public class ObserverImage implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		try {
			((EcouteurMenu)o).getModel().setImg(new Image((File) arg));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	

}
