package displayComponent.background;

import java.awt.Image;
import java.net.URL;

import javax.swing.JComponent;

public abstract class BackGround extends JComponent {
	
	protected URL url;
	protected int imageX;
	protected int imageY;
	
	public BackGround(int imageX, int imageY) {
		this.imageX = imageX;
		this.imageY = imageY;
	}
	
	public abstract Image getIm();

	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}


}
