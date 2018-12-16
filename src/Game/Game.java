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

	public Game(String path) {
		packmen=new ArrayList<PackMan>();
		fruits=new ArrayList<Fruit>();
		read(path);
	}
	public Game() {
		packmen=new ArrayList<PackMan>();
		fruits=new ArrayList<Fruit>();
	}
	/**
	 * using the path it reads the csv file and builds packmen and fruits
	 */
	public void read(String path) {
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
	/**
	 * writes a csv file using the packmen and fruits in the folder that the path points to
	 */
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
		sb.append("Type,id,Lat,Lon,Alt,Speed,Radius,\n");
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
	public ArrayList<Fruit> getFruits(){
		return new ArrayList<Fruit>(fruits);
	}
	public ArrayList<PackMan> getPackmen(){//no new so we can change the path for each packman
		return packmen;
	}
	public void addPackMan(PackMan p) {
		packmen.add(p);
	}
	public void addFruit(Fruit f) {
		fruits.add(f);
	}
}
