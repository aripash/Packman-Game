package Game;

import Geom.Point3D;
/**
 * this class represents a packman in a game and implements functions that every packman needs.
 * 	1.	find nearest fruit
 * 	2.	"eat" fruit
 * 	3.	move on the game board
 *
 */
public class PackMan extends gameElement{
	private double speed;
	private double radius;
	private double score;
	
	/**
	 * this function creates a packman object with no game score.
	 * color is a string that represents a color, is to be used later when object is drawn
	 * @param gps should be a valid Point3D object
	 * @param speed represents the speed which the packamn "moves", and should be positive
	 * @param radius represents the packman's "eating" distance, and should be positive
	 */
	public PackMan(Point3D gps,double speed,double radius) {
		super(gps);
		this.speed=speed;	//try and catch if value is 0 or negative
		this.radius=radius;		//try and catch if value is 0 or negative
		this.setColor("yellow");
		this.setScore(0);
	}
	public String toString() {
		return gps.x()+","+gps.y()+","+gps.z()+",\n"+"speed: "+this.speed+"\n"+"radius: "+this.radius;
	}
	public double getScore() {
		return score;
	}
	private void setScore(double score) {
		this.score = score;
	}
	/**
	 * this function is used to "eat
	 * @param f
	 */
	public void eat(Fruit f) {
		double score=this.getScore();
		score+= f.getValue();
		this.setScore(score);
	}
	/**
	 * this function receives a list of fruits (that is supposed to be on the game board)
	 * and returns the closest fruit to packman geographically
	 * @return fruit object
	 */
	public Fruit findNearestFruit(FruitList fl) {
		return null;
	}
	/**
	 * this function is used to "move" the packman to desired fruit.
	 * @param f
	 */
	public void move(Fruit f) {
		
	}
}
