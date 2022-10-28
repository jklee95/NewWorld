package displayComponent.background;

import gui.mainUI.roundUI.PlayUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Dark extends BackGround {
	
	private Image[] im = new Image[30];
	
	private int motionNum;
	private int count;
	
	private boolean darkFlag = false;
	
	public Dark(int imageX, int imageY) {
		super(imageX, imageY);
		
		for (int i = 0; i < im.length; i++) {
			if ((url = getClass().getClassLoader().getResource("image/background/dark" + "/position" + (i + 1) + ".png")) != null) {
				im[i] = Toolkit.getDefaultToolkit().getImage(url);
			}
		}
		
	}
	
	public void makeDark() {
		
		Timer timer = new Timer();
    	TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if (im[count + 1] != null) {
					motionNum++;
					count++;
				} else {
					
					
					// 뒤로 가기 (다시 밝아지기)
					if (darkFlag) {
						motionNum --;
						
						// 완전히 밝아지면
						if (motionNum == 0) {
							timer.cancel();
							remove();
							count = 0;
							darkFlag = false;
						}
						
					}
					
				}
				
				
			}
    	};
    	timer.schedule(task, 0, 70);
	}
	

	public void remove() {
		PlayUI.getDisplayComponent().getBackGround().remove(this);
	}
	
	public Image getIm() {
		return im[motionNum];
	}

	public void setDarkFlag(boolean darkFlag) {
		this.darkFlag = darkFlag;
	}
	
}
