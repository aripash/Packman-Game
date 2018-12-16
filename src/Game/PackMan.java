package Game;

import Geom.Point3D;

public class PackMan {
private Point3D gps;
private int speed;
private int radius;
private Path path;
public PackMan(Point3D gps,int speed,int radius) {
	this.gps=gps;
	this.speed=speed;
	this.radius=radius;
	this.path=new Path();
	path.add(gps);
}
public String toString() {
	return gps.x()+","+gps.y()+","+gps.z()+","+speed+","+radius+",";
}
public Path getPath() {
	return new Path(path);
}
/**
 * adds a point to the path of the packman
 * @param p the next gps point the packman needs to move
 */
public void add(Point3D p) {
	path.add(p);
}
public int getSpeed() {
	return speed;
}
}
