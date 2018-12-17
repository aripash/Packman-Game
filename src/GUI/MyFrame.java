package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Game.Fruit;
import Game.Game;
import Game.Map;
import Game.PackMan;
import Geom.Point3D;

public class MyFrame extends JFrame implements MouseListener,ActionListener{
	public BufferedImage image;
	private Game game;
	private Map map;
	private String what;

	public MyFrame(String imagePath,String name) {
		super(name);
		this.game=new Game();
		startimage(imagePath);		
		this.addMouseListener(this); 

	}
	public void startimage(String imagePath) {
		try {
			image = ImageIO.read(new File(imagePath));//"C:/Users/Owner/Desktop/Ex3/Ex3/Ex3/Ariel1.png"
		} catch (IOException e) {
			e.printStackTrace();
		}	
		this.map=new Map(image);
		MenuBar menuBar = new MenuBar();
		Menu menu1=new Menu("File");
		MenuItem item1a = new MenuItem("Save");
		MenuItem item1b = new MenuItem("Load");

		menuBar.add(menu1);
		menu1.add(item1a);
		menu1.add(item1b);

		Menu menu2 = new Menu("Add"); 
		MenuItem item2a = new MenuItem("Packman");
		MenuItem item2b = new MenuItem("Fruit");

		menuBar.add(menu2);
		menu2.add(item2a);
		menu2.add(item2b);

		Menu menu3 = new Menu("Game"); 
		MenuItem item3 = new MenuItem("Start");

		menuBar.add(menu3);
		menu3.add(item3);
		this.setMenuBar(menuBar);

		item1a.addActionListener(this);
		item1b.addActionListener(this);
		item2a.addActionListener(this);
		item2b.addActionListener(this);
		item3.addActionListener(this);

	}

	public void paint(Graphics g){
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		map.setWidth(this.getWidth());
		map.setHeight(this.getHeight());
		if(!game.getPackmen().isEmpty()) {
			Iterator<PackMan> i=this.game.getPackmen().iterator();
			while(i.hasNext()) {
				g.setColor(Color.yellow);
				PackMan pi=i.next();
				int[] pix=map.convC2P(pi.getLastGps());
				g.fillOval(pix[0], pix[1], pi.getRadius(), pi.getRadius());
				g.setColor(Color.black);
				g.drawOval(pix[0], pix[1], pi.getRadius(), pi.getRadius());
			}
		}
		if(!game.getFruits().isEmpty()) {
			Iterator<Fruit> j=this.game.getFruits().iterator();
			while(j.hasNext()) {
				g.setColor(Color.red);
				Fruit fi=j.next();
				int[] pix=map.convC2P(fi.getFruit());
				g.fillOval(pix[0],pix[1], 15, 15);
				g.setColor(Color.black);
				g.drawOval(pix[0],pix[1], 15, 15);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		try {
			if(what.equalsIgnoreCase("P")) {
				Point3D point=map.convP2C(arg0.getX(), arg0.getY(), 0);
				game.addPackMan(new PackMan(point));
				repaint();
			}
			else if(what.equalsIgnoreCase("F")) {
				Point3D point=map.convP2C(arg0.getX(), arg0.getY(), 0);
				game.addFruit(new Fruit(point));
				repaint();
			}
		}
		catch(Exception e){

		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equalsIgnoreCase("Save")) {
			JFileChooser fc = new JFileChooser();
			int value=fc.showSaveDialog(null);
			if(value==fc.APPROVE_OPTION) {
				File file=fc.getSelectedFile();
				game.write(file.getPath());
			}
		}
		if(e.getActionCommand().equalsIgnoreCase("Load")) {
			JFileChooser fc = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("csv","CSV");
			fc.setFileFilter(filter);
			int value=fc.showOpenDialog(null);
			if(value==fc.APPROVE_OPTION) {
				File file=fc.getSelectedFile();
				this.game=new Game(file.getPath());
				System.out.println(game);
				repaint();
			}


		}
		if(e.getActionCommand().equalsIgnoreCase("Packman")) {
			what="P";
		}
		if(e.getActionCommand().equalsIgnoreCase("Fruit")) {
			what="F";
		}
		if(e.getActionCommand().equalsIgnoreCase("Start")) {

		}
	}
}
