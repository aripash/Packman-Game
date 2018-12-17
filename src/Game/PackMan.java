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
	 * function is used to find which two points of path the packman is in between in given time after the game started
	 * @param time is the amount of time traveled by packman
	 * @return array representing the two point that the packman is between
	 */
	public Point3D[] whichPoints(double time) {
		Point3D[] rng=new Point3D[2];
		MyCoords c=new MyCoords();
		double searchDistance1=0;
		double searchDistance2=0;
		double distance=time*this.speed;
		Iterator<Point3D> i=this.path.iterator();
		Point3D pi=i.next();			////////do you have an idea what to do if array only has it's first element?////////
		while(i.hasNext()) {
			Point3D temp=i.next();
			searchDistance2=c.distance3d(pi, temp);
			if(distance>=searchDistance1&&distance<=searchDistance2) {
				rng[0]=pi;
				rng[1]=temp;
				return rng;
			}
			pi=temp;
			searchDistance1=searchDistance2;
		}

		return rng;
	}
	/**
	 * Function is used to find the location of packman in percentage in between to points
	 * @param time is the amount of time traveled by packman
	 * @return
	 */
	public double locationInTime(double time) {
		double location;
		Point3D[] rng =new Point3D[2];
		MyCoords c=new MyCoords();
		double searchDistance1=0;
		double searchDistance2=0;
		double distance=time*this.speed;
		Iterator<Point3D> i=this.path.iterator();
		Point3D pi=i.next();
		Point3D first=new Point3D (pi);
		while(i.hasNext()) {
			Point3D temp=i.next();
			searchDistance2=c.distance3d(pi, temp);
			if(distance>=searchDistance1&&distance<=searchDistance2) {
				rng[0]=pi;
				rng[1]=temp;
			}
			pi=temp;
			searchDistance1=searchDistance2;
		}

		location=	distance - c.distance3d(first, rng[0]);
		location/=	c.distance3d(rng[0], rng[1]);
		return location;
	}
}