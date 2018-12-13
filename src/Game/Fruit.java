package Game;

import Geom.Point3D; 

public class Fruit{
private Point3D gps;

public Fruit(Point3D gps) {
	this.gps=new Point3D(gps);
}
public String toString() {
	return gps.x()+","+gps.y()+","+gps.z()+",";
}
}
