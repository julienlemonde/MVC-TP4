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
		
		public Perspective(int translationX,int translationY, int positionXDepart,int positionYDepart, double scale)
		{
			this.translateX = translationX;
			this.translateY = translationY;
			this.positionXDepart = positionXDepart;
			this.positionYDepart = positionYDepart;
			this.scale = scale;
		}

		public int getPositionXDepart() {
			return positionXDepart;
		}

		public void setPositionXDepart(int positionXDepart) {
			this.positionXDepart = positionXDepart;
		}

		public int getPositionYDepart() {
			return positionYDepart;
		}

		public void setPositionYDepart(int positionYDepart) {
			this.positionYDepart = positionYDepart;
		}

		public int getTranslateX() {
			return translateX;
		}

		public void setTranslateX(int translateX) {
			this.translateX = translateX;
		}

		public int getTranslateY() {
			return translateY;
		}

		public void setTranslateY(int translateY) {
			this.translateY = translateY;
		}

		public double getScale() {
			return scale;
		}

		public void setScale(double scale) {
			this.scale = scale;
		}
		
		public void setTranslation(int x, int y)
		{
			this.translateX = x;
			this.translateY = y;
			
		}
		public void copyThisPerpective(Perspective p){
			this.translateX = p.getTranslateX();
			this.translateY = p.getTranslateY();
			this.scale = p.getScale();
			this.positionXDepart = p.getPositionXDepart();
			this.positionYDepart = p.getPositionYDepart();
		}
		

		
}
