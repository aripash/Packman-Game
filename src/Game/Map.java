package Game;

import java.awt.Image;

import Coords.MyCoords;
import GUI.MyFrame;
import Geom.Point3D;

public class Map {
private	Image mapImage;
	public Map(String path) {
		MyFrame mg=new MyFrame(path);
		this.mapImage=mg.image;
	}
public Point3D convP2C(int pixX,int pixY,double alt) {
	int width=mapImage.getWidth(null);
	int hight=mapImage.getHeight(null);
	double diffX=pixX/(double)width;
	double diffY=pixY/(double)hight;
	diffX*=0.009531;//the difference in longitude between the top left and top right (32.105733,35.202401)-(32.105685,35.211932)
	diffY*=0.00383;//the difference in latitude between the top left and bottom left(32.105733,35.202401)-(32.101903,35.202338)
	diffX+=35.202401;
	diffY+=32.105733;
	return new Point3D(diffX,diffY,alt);
}
public int [] convC2P(Point3D gps) {
	int width=mapImage.getWidth(null);
	int hight=mapImage.getHeight(null);
	double pixX=gps.x();
	double pixY=gps.y();
	pixX-=35.202401;
	pixY-=32.105733;
	pixX/=0.009531;
	pixY/=0.00383;
	pixX*=width;
	pixY*=hight;
	int[]ans= {(int)pixX,(int)pixY};
	return ans;
}
public double[] distance(int x1,int y1,int x2,int y2) {
	Point3D a=convP2C(x1,y1,0);
	Point3D b=convP2C(x2,y2,0);
	MyCoords cord=new MyCoords();
	return cord.azimuth_elevation_dist(a, b);
}
}
