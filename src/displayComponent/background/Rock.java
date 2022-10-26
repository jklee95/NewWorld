package displayComponent.background;
import java.awt.Image;
import java.awt.Toolkit;


public class Rock extends BackGround {
	
	private Image im;
	
	public Rock(int imageX, int imageY) {
		super(imageX, imageY);
		
		this.url = getClass().getClassLoader().getResource("image/background/rock/rockAll.png");
		this.im = Toolkit.getDefaultToolkit().getImage(url);
	}
	
	public Image getIm() {
		return im;
	}
	
	
}
