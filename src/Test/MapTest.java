package Test;

import javax.swing.JFrame;

import GUI.MyFrame;


public class MapTest{
	public static void main(String[] args){
		MyFrame window = new MyFrame("C:/Users/Owner/Desktop/Ex3/Ex3/Ex3/Ariel1.png");
		window.setVisible(true);
		window.setResizable(true);
		window.setSize(window.image.getWidth(),window.image.getHeight());
		
		window.setName("Packman");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
