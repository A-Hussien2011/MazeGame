package gameEngine.controller;

import javax.swing.ImageIcon;

public class SharedIcons extends AbstractFlyweightIcons{

	String imgPath;
	public SharedIcons(String s){
		imgPath = s;
	}
	@Override
	public ImageIcon getIcon() {
		return ImageIconFactory.getImageIcon(imgPath);
	}

}
