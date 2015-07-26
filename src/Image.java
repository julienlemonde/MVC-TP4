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

	/**
	 * Constructeur qui prend un fichier et le transforme en image
	 * @param file Le fichier qui a ete choisi par l'utilisateur 
	 * @throws IOException Si le fichier est null
	 */
	public Image(File file) throws IOException
	{
		
        image = ImageIO.read(file);
        x = image.getWidth();
        y = image.getHeight();
        
	}
	
	/**
	 * Accesseur de la longueur de l'image
	 * @return la longeur x de l'image
	 */
	public int getWidth()
	{
		return x;
	}
	/**
	 * Accesseur de la hauteur de l'image
	 * @return la longueur y de l'image
	 */
	public int getHeight()
	{
		return y;
	}
	/**
	 * Accesseur de l'image
	 * @return Un objet de type BufferedImage
	 */
	public BufferedImage getBufferedImage()
	{
		return image;
	}
	

}