package Game;

import Geom.Point3D;

public class PackMan {
private Point3D gps;
private int speed;
private int radius;
public PackMan(Point3D gps,int speed,int radius) {
	this.gps=gps;
	this.speed=speed;
	this.radius=radius;
}
public String toString() {
	return gps.x()+","+gps.y()+","+gps.z()+","+speed+","+radius+",";
}
}
