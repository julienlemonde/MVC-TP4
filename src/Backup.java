import java.io.Serializable;


public class Backup implements Serializable{
	
	private static final long serialVersionUID = 9068049371126709578L;
	private Perspective p1;
	private Perspective p2;
	
	/**
	 * Constructeur de la classe backup
	 * @param p La premiere perspective a enregistrer
	 * @param pp La deuxieme perspective a enregistrer
	 */
	public Backup(Perspective p, Perspective pp){
		p1 = p;
		p2 = pp;
	}
	/**
	 * Mutateur de la premiere perspective
	 * @param p La nouvelle perspective
	 */
	public void setP1(Perspective p){
		this.p1 = p;
	}
	/**
	 * Mutateur de la deuxieme perspective
	 * @param p La nouvelle perspective
	 */
	public void setP2(Perspective p){
		this.p2 = p;
	}
	/**
	 * Accesseur de la premiere perspective
	 * @return Un objet de type perspective
	 */
	public Perspective getP1(){
		return this.p1;
	}
	/**
	 * Accesseur de la deuxieme perspective
	 * @return Un object de type perspective
	 */
	public Perspective getP2(){
		return this.p2;
	}
}