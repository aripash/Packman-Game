package File_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;

import Game.Fruit;
import Game.Game;
import Game.PackMan;

public class Path2KML {
	private Game game;
	public Path2KML(Game game) {
		this.game=game;
	}
	public void write(String path) {
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter(new File(path));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\"");
		sb.append("xmlns:gx=\"http://www.google.com/kml/ext/2.2\">");
		sb.append("<Document>");
		sb.append("<name>PackMan</name>");
		Iterator<PackMan> i=game.getPackmen().iterator();
		while(i.hasNext()) {
			PackMan pi=i.next();
			int time=0;
			while(time<game.lastTime()+2) {
				sb.append("<Placemark>");
				sb.append("<TimeStamp>");
				sb.append("<when>");
				if(time<10)sb.append("2018-08-16T22:00:0"+time);
				else sb.append("2018-08-16T22:00:"+time);
				sb.append("</when>");
				sb.append("</TimeStamp>");
				sb.append("<styleURL>");
				sb.append("#hiker-icon");
				sb.append("</styleURL>");
				sb.append("<Point>");
				sb.append("<coordinates>");
				sb.append(pi.currentPoint(time).toString());
				sb.append("</coordinates>");
				sb.append("</Point>");
				sb.append("</Placemark>");
			}
		}
		sb.append("</Document>");
		sb.append("</kml>");
		pw.write(sb.toString());
		pw.close();
	}
}
