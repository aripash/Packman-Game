package Game;

import javax.swing.JFrame;

import GUI.MyFrame;

public class Start {
	public static void main(String[]args) {
		Play("C:/Users/Owner/Desktop/Ex3/Ex3/Ex3/Ariel1.png");
	}
public static void Play(String path) {
	MyFrame window = new MyFrame(path,"Packman");
	window.setVisible(true);
	window.setSize(window.image.getWidth(),window.image.getHeight());
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(true);
}
}