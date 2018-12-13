package GUI;

import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements MouseListener{
public BufferedImage image;
	
	public MyFrame(String imagePath) {
		startimage(imagePath);		
		this.addMouseListener(this); 
	}
	public void startimage(String imagePath) {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Add"); 
		MenuItem item1 = new MenuItem("Packman");
		MenuItem item2 = new MenuItem("Fruit");
		
		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		this.setMenuBar(menuBar);
		
		try {
			image = ImageIO.read(new File(imagePath));//"C:/Users/Owner/Desktop/Ex3/Ex3/Ex3/Ariel1.png"
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void paint(Graphics g)
	{
		g.drawImage(image, 0, 0, this);
	}
	
int x;
int y;
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("mouse Clicked");
		System.out.println("("+ arg0.getX() + "," + arg0.getY() +")");
		x = arg0.getX();
		y = arg0.getY();
		repaint();
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

}
