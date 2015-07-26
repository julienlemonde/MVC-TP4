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
	 private Perspective perspective;
	 private double scale;
	 private double ratiowidth;
	 private double ratioheight;
	 
	/**
	 * Constructeur du panneau d'image
	 * @param img L'image qui sera afficher
	 * @param AEcouter True s'il doit etre ecouter ou non
	 */
	public ImagePanel(Image img, boolean AEcouter)
	{
		this.img = img;
		dms = new Dimension(400,300);
		this.setPreferredSize(dms);
		perspective = new Perspective(0, 0, 0, 0, 0.33333333);
		
		
		
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
	/**
	 * Methode pour savoir de quelle type d'action il s'Agit et paint de facon différente
	 * @param g Graphic de super
	 * @param Type Le type d'Action il s'agit
	 */
	public void paintComponent(Graphics g, String Type){
		super.paintComponent(g);
		double z = perspective.getScale()*perspective.getScale();
		Graphics2D ourGraphics = (Graphics2D) g;
		AffineTransform t = new AffineTransform();
		double currentImgWidth = img.getWidth()*z, currentImgHeight = img.getHeight()*z;
		if(Type =="scale")
		{

			perspective.setPositionXDepart((int) (this.getWidth()/2 - (currentImgWidth/2)));
			perspective.setPositionYDepart((int) (this.getHeight()/2-(currentImgHeight/2)));
			t.translate(perspective.getPositionXDepart(), perspective.getPositionYDepart());
			
		}
		
		else if(Type == "translation")
		{
			perspective.setPositionXDepart(perspective.getPositionXDepart()+perspective.getTranslateX());
			perspective.setPositionYDepart(perspective.getPositionYDepart()+perspective.getTranslateY());
			t.translate(perspective.getPositionXDepart(), perspective.getPositionYDepart());
		}
		
		
		t.scale(z,z);
		//Et j'affiche en utilisant la transformation
		ourGraphics.drawImage(img.getBufferedImage(),t, null);

		//On lib��re un peu de m��moire histoire de laisser le GC tranquille un peu plus longtemps
		ourGraphics.dispose();
		
	}
	
	/**
	 * Accesseur de l'image du panel
	 * @return Un objet de type Image
	 */
	public Image getImage()
	{
		return img;
	}
	/**
	 * Mutateur de l'image du panel
	 * @param nouvelleImage La nouvelle image
	 */
	public void setImage(Image nouvelleImage)
	{
		img = nouvelleImage;
		perspective = new Perspective(0, 0, 0, 0, .55);
		repaint();
	}
	public Dimension getDimension(){
		return dms;
	}
	
	public void setTranslation(int witdh,int height)
	{
		perspective.setTranslateX(witdh);
		perspective.setTranslateY(height);
		paintComponent(super.getGraphics(),"translation");
	}
	public void setScale(int nombreZoom)
	{
		perspective.setScale(perspective.getScale() + (.01 * nombreZoom));
		perspective.setScale(Math.max(0.00001, perspective.getScale())); 
		paintComponent(super.getGraphics(),"scale");
	}
	public Perspective getPerspective(){
		return perspective;
	}

	
	
}
