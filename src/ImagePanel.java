import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	
	 private Image img;
	 private Dimension dms;
	
	public ImagePanel(Image img)
	{
		this.img = img;
		dms = new Dimension(500,500);
		this.setPreferredSize(dms);
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img != null){
            g.drawImage(img.getBufferedImage(), 0, 0,dms.width ,dms.height,this);
                 
        }
    }
}
