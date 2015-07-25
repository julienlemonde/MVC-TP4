import java.awt.Dimension;


public class Translation implements Command {
	private int witdh;
	private int height;
	private ImagePanel panel;
	
	public Translation(Dimension dimension, ImagePanel panelOrigine)
	{
		witdh = dimension.width;
		height = dimension.height;
		this.panel = panelOrigine;
	}
	
	public void execute()
	{
		this.panel.setTranslation(witdh, height);
		
	}
	public void undo()
	{
		this.panel.setTranslation(-witdh, -height);
	}
}
