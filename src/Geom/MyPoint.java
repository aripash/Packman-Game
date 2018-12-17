package Geom;

public class MyPoint extends Point3D{
	private double time;
public MyPoint(double x, double y,double z,double time) {
	super(x,y,z);
	this.time=time;
}
public MyPoint(double x, double y,double z) {
	super(x,y,z);
}
public MyPoint(Point3D p) {
	super(p);
}
public double getTime() {
	return time;
}
}
