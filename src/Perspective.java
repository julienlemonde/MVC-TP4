import java.awt.Dimension;
import java.io.Serializable;


public class Perspective implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5793748608249541061L;
		private int translateX;
		private int translateY;
		private int positionXDepart;
		int positionYDepart;
		private double scale;
		
		/**
		 * Constructeur d'une perspective pour un panel
		 * @param translationX La derniere translation effectuer selon le point X d'origine
		 * @param translationY La derniere translation effectuer selon le point Y d'origine
		 * @param positionXDepart La position X de depart, Change selon les actions
		 * @param positionYDepart La position Y de depart, Change selon les actions
		 * @param scale 
		 */
		public Perspective(int translationX,int translationY, int positionXDepart,int positionYDepart, double scale)
		{
			this.translateX = translationX;
			this.translateY = translationY;
			this.positionXDepart = positionXDepart;
			this.positionYDepart = positionYDepart;
			this.scale = scale;
		}
		/**
		 * Accesseur de la position x de Depart
		 * @return Un int de la position x de depart
		 */
		public int getPositionXDepart() {
			return positionXDepart;
		}

		/**
		 * Mutateur de la position X de depart
		 * @param positionXDepart la nouvelle position
		 */
		public void setPositionXDepart(int positionXDepart) {
			this.positionXDepart = positionXDepart;
		}

		/**
		 * Accesseur de la position Y de depart
		 * @return Un int de la position Y de depart
		 */
		public int getPositionYDepart() {
			return positionYDepart;
		}

		/**
		 * Mutateur de la position Y de Depart
		 * @param positionYDepart La nouvelle position
		 */
		public void setPositionYDepart(int positionYDepart) {
			this.positionYDepart = positionYDepart;
		}
		/**
		 * Accesseur de la translation en X
		 * @return Un int de la valeur de la translation en X
		 */
		public int getTranslateX() {
			return translateX;
		}

		/**
		 * Mutateur de la translation en X
		 * @param translateX La nouvelle translation en X
		 */
		public void setTranslateX(int translateX) {
			this.translateX = translateX;
		}
		/**
		 * Accesseur de la translation en Y
		 * @return Un int de la translation en Y
		 */
		public int getTranslateY() {
			return translateY;
		}
		/**
		 * Mutateur de la translation en Y
		 * @param translateX La nouvelle translation en Y
		 */
		public void setTranslateY(int translateY) {
			this.translateY = translateY;
		}
		/**
		 * Accesseur du scale appliquer
		 * @return Un double de la valeur du scale
		 */
		public double getScale() {
			return scale;
		}
		/**
		 * Mutateur du scale a appliquer
		 * @param scale le nouveau scale
		 */
		public void setScale(double scale) {
			this.scale = scale;
		}
		/**
		 * Methode pour changer les valeurs en X et en Y de la translation
		 * @param x Translation en X
		 * @param y Translation en Y
		 */
		public void setTranslation(int x, int y)
		{
			this.translateX = x;
			this.translateY = y;
			
		}
		/**
		 * Methode copier une perspective
		 * @param p La nouvelle perspective
		 */
		public void copyThisPerpective(Perspective p){
			this.translateX = p.getTranslateX();
			this.translateY = p.getTranslateY();
			this.scale = p.getScale();
			this.positionXDepart = p.getPositionXDepart();
			this.positionYDepart = p.getPositionYDepart();
		}
		

		
}
