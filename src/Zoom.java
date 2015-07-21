import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Zoom implements Command {

	private int notchesZoom;
	private ImagePanel panel;
	public Zoom(int NombreOfZoom, ImagePanel panelOrigine)
	{
		notchesZoom = NombreOfZoom;
		this.panel = panelOrigine;
	}
	public void execute() {
		this.panel.setScale(notchesZoom);
	}
	

}
