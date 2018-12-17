package Game;

import java.util.Iterator;

import Coords.MyCoords;
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
/**
 * returns the two points the packman is between in the "time" second
 * @param time the amout time the packman traveled
 * @return array of points that the packman can be between
 */
public Point3D[] range(double time) {
	Point3D[] ans=new Point3D[2];
	MyCoords c=new MyCoords();
	double searchDistance1=0;
	double searchDistance2=0;
	double distance=time*speed;
	Iterator<Point3D> i=path.iterator();
	Point3D pi=i.next();
	while(i.hasNext()) {
		Point3D temp=i.next();
		searchDistance2=c.distance3d(pi, temp);
		if(distance>=searchDistance1&&distance<=searchDistance2) {
			ans[0]=pi;
			ans[1]=temp;
			return ans;
		}
		pi=temp;
		searchDistance1=searchDistance2;
	}
	return null;
}
}
