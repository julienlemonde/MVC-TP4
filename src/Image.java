import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Image extends JLabel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1794555283950670496L;
	private int x;
	private int y;
	BufferedImage image;

	public Image(File file) throws IOException
	{
		
        image = ImageIO.read(file);
        x = image.getWidth();
        y = image.getHeight();
        
	}
	
	
	public int getWidth()
	{
		return x;
	}

	public int getHeight()
	{
		return y;
	}
	
	
	
	public BufferedImage getBufferedImage()
	{
		return image;
	}
	

}