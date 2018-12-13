package Game;

import Geom.Point3D; 

abstract class gameElement {
	protected Point3D gps;
	String color;

	public gameElement(Point3D p) {
		this.setGps(new Point3D(p));
	}

	public Point3D getGps() {
		return this.gps;
	}

	protected void setGps(Point3D gps) {
		this.gps = gps;
	}
	public String getColor() {
		return this.color;
	}
	protected void setColor(String s) {
		this.color=s;
	}
	public String toString() {
		return gps.x()+","+gps.y()+","+gps.z();
	}
}


