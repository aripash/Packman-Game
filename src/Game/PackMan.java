package Game;

import Geom.Point3D;

public class PackMan {
private Point3D gps;
private int speed;
private double radius;
private Path path;
public PackMan(Point3D gps,int speed,int radius) {
	this.gps=new Point3D(gps);
	this.speed=speed;
	this.radius=radius;
	this.path=new Path();
	path.add(gps);
}
public PackMan(Point3D gps) {
	this.gps=new Point3D(gps);
	this.speed=5;
	this.radius=1;
	this.path=new Path();
	path.add(gps);
}
public String toString() {
	return gps.y()+","+gps.x()+","+gps.z()+","+speed+","+radius+",";
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
public double pathDist() {
	return path.distance();
}
public double Time(double dist) {
	double ans=dist/speed;
	return ans;
}
public double getRadius() {
	return radius;
}
public Point3D getLastGps() {
	return path.getPoints().get(path.getPoints().size()-1);
}
}
