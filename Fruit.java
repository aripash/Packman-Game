package Game;

import Geom.Point3D; 
/**
 * this class represents a "fruit" in a packman game.
 *
 */
public class Fruit extends gameElement{
	private double value;

	/**
	 * this function creates a fruit object with no game value. should not be actually used. (consider deleting later)
	 * color is a string that represents a color, is to be used later when object is drawn
	 * @param p should be a valid Point3D object
	 */
	public Fruit(Point3D p) {
		super(p);
		this.value=0;
		super.setColor("red");

	}
	/**
	 * this function creates a fruit object with given game value, and should be the function used to create new fruits
	 * color is a string that represents a color, is to be used later when object is drawn
	 * @param p should be a valid Point3D object
	 */
	public Fruit(Point3D p, double v) {
		super(p);
		this.value=v;
		super.setColor("red");
	}
	public String toString() {
		return getGps().x()+","+getGps().y()+","+getGps().z()+",\nvalue: "+this.getValue();
	}


	public double getValue() {
		return this.value;
	}
}
