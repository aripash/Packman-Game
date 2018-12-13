package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import Geom.Point3D;

public class Game {
	private ArrayList<PackMan> packmen;
	private ArrayList<Fruit> fruits;
	private String path;
	
	public void read(String path) {
		this.path=path;
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] lineData = line.split(cvsSplitBy);
				Point3D gps=new Point3D(Double.parseDouble(lineData[2]),Double.parseDouble(lineData[3]),Double.parseDouble(lineData[4]));
				if(lineData[0].equalsIgnoreCase("F")) {
					fruits.add(new Fruit(gps));
				}
				else if(lineData[0].equalsIgnoreCase("P")) {
					PackMan p=new PackMan(gps,Integer.parseInt(lineData[5]),Integer.parseInt(lineData[6]));
					packmen.add(p);
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public void write() {
		PrintWriter pw = null;
		try 
		{
			if(path.charAt(path.length()-1)=='/')path=path.substring(0, path.length());
			String nPath=path.substring(0, path.lastIndexOf("/"));
			pw = new PrintWriter(new File(nPath));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
		StringBuilder sb = new StringBuilder();
		Iterator<PackMan> i1=packmen.iterator();
		Iterator<Fruit> i2=fruits.iterator();
		int j=0;
		while(i1.hasNext()) {
			sb.append("P,");
			sb.append(j+",");
			j++;
			sb.append(i1.next().toString());
			sb.append("\n");
		}
		j=0;
		while(i2.hasNext()) {
			sb.append("F,");
			sb.append(j+",");
			j++;
			sb.append(i2.next().toString());
			sb.append("\n");
		}
		pw.write(sb.toString());
		pw.close();
		System.out.println("done!");
	}
}
