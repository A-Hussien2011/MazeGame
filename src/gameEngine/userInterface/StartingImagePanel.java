package gameEngine.userInterface;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class StartingImagePanel extends JPanel{

	private Image img;
	
	public StartingImagePanel(Image m) {
		img = m;
	}
	@Override
	  public void paintComponent(Graphics g) {
		  g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), null);
	  }
}
