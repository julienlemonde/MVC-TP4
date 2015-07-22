import java.io.Serializable;
import java.util.Observable;



public class Model extends Observable implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2975882143448572952L;
	private Image img;
	private ImagePanel imgpanel;
	private ImagePanel imgpanel2;
	private ImagePanel imgpanel3;
	
	public Model(Image img)
	{
		this.img = img;
		imgpanel = new ImagePanel(img,false);
		imgpanel2 = new ImagePanel(img,true);
		imgpanel3 = new ImagePanel(img, true);
		
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
		imgpanel.setImage(img);
		imgpanel2.setImage(img);
		imgpanel3.setImage(img);
		setChanged();
		notifyObservers(this.img);
	}

	public ImagePanel getPanel1() {
		return imgpanel;
	}


	public ImagePanel getPanel2(){
		return imgpanel2;
	}
	public ImagePanel getPanel3()
	{
		return imgpanel3;
	}
	
	
	
	
	
}
