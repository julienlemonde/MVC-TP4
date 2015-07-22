import java.io.Serializable;


public class Backup implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9068049371126709578L;
	private Perspective p1;
	private Perspective p2;
	
	public Backup(Perspective p, Perspective pp){
		p1 = p;
		p2 = pp;
	}
	public void setP1(Perspective p){
		this.p1 = p;
	}
	public void setP2(Perspective p){
		this.p2 = p;
	}
}
