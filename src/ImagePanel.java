import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	
	 private Image img;
	 private Dimension dms;
	 private int translateX;
	 private int translateY;
	 private int positionXDepart;
	 private int positionYDepart;
	 private double scale;
	 
	
	public ImagePanel(Image img, boolean AEcouter)
	{
		this.img = img;
		dms = new Dimension(400,300);
		this.setPreferredSize(dms);
		translateX = 0;
		translateY = 0;
		positionXDepart = 0;
		positionYDepart = 0;
		scale = 0.5;
		
		
		if(AEcouter)
		{
			EcouteurSouris souris = new EcouteurSouris(this);
			this.addMouseListener(souris);
			this.addMouseWheelListener(souris);
		}
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
        if(img != null){
        	
        	g.drawImage(img.getBufferedImage(), 0, 0,dms.width ,dms.height,this);
	
        	}
        	
        
            
                 
        
    }
	public void paintComponent(Graphics g, String Type){
		super.paintComponent(g);
		double z = scale*scale;
		Graphics2D ourGraphics = (Graphics2D) g;
		AffineTransform t = new AffineTransform();
		double currentImgWidth = img.getWidth()*z, currentImgHeight = img.getHeight()*z;
		if(Type =="scale")
		{

			positionXDepart = (int) (currentImgWidth/2);
			positionYDepart = (int) (currentImgHeight/2);
			t.translate(positionXDepart,positionYDepart);
			
		}
		
		if(Type == "translation")
		{
			positionXDepart+=translateX;
			positionYDepart+=translateY;
			t.translate(positionXDepart, positionYDepart);
		}
		
		
		t.scale(z,z);
		//Et j'affiche en utilisant la transformation
		ourGraphics.drawImage(img.getBufferedImage(),t, null);

		//On libère un peu de mémoire histoire de laisser le GC tranquille un peu plus longtemps
		ourGraphics.dispose();
		
	}
	
	public Image getImage()
	{
		return img;
	}
	public Dimension getDimension(){
		return dms;
	}
	
	public void setTranslation(int witdh,int height)
	{
		translateX = witdh;
		translateY = height;
		paintComponent(super.getGraphics(),"translation");
	}
	public void setScale(int nombreZoom)
	{
		this.scale += (.01 * nombreZoom);
		this.scale = Math.max(0.00001, this.scale); 
		paintComponent(super.getGraphics(),"scale");
	}

	
	
}
