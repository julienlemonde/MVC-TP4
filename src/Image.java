import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Image extends JLabel {
	
	private JLabel label;
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

	public void DrawImage()
	{
		Graphics g = image.getGraphics();
		g.drawImage(image, 0, 0, null);
	}
	
	public BufferedImage getBufferedImage()
	{
		return image;
	}

}