package movie;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Main_FirstScreen extends JPanel{
	private Image backgroundImage;
	Main_Frame mf;
	
	public Main_FirstScreen(Main_Frame mf){
		this.mf = mf;
		
		try {
			backgroundImage = ImageIO.read(new File("main1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSize(700,1000);
		
	}
	@Override
	protected void paintComponent(Graphics g) {	
		super.paintComponent(g);
		g.drawImage(backgroundImage,0,0,700,1000,null);			
	}
}
