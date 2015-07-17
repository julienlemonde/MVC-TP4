import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Observable;


public class EcouteurSouris extends Observable implements MouseListener, MouseWheelListener {

	private int xPressed;
	private int yPressed;
	private int xRelease;
	private int yRelease;
	private Dimension translation;
	private boolean scrolled;
	
	
	public EcouteurSouris() {
		// TODO Auto-generated constructor stub
		ObserverSouris obs = new ObserverSouris();
		this.addObserver(obs);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		xPressed = e.getX();
		yPressed = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		xRelease = e.getX();
		yRelease = e.getY();
		boolean test = true;
		translation = new Dimension(xRelease - xPressed, yRelease - yPressed);
		setChanged();
		notifyObservers(test);
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
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		scrolled = true;
		e.getWheelRotation();
		setChanged();
		notifyObservers(scrolled);
		scrolled = false;
	}

}
