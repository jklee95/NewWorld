package displayComponent.damage;

import gui.mainUI.roundUI.PlayUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import displayComponent.DisplayComponent;

public class DamageNumber {

	private Image im[] = new Image[8];
	private char damageNumber;
	private String animalName;
	private int count;
	private int imageX;
	private int imageY;
	private int arrayNum;
	
	public DamageNumber(char damageNumber, String animalName, int imageX, int imageY) {
		this.damageNumber = damageNumber;
		this.animalName = animalName;
		this.imageX = imageX; 
		this.imageY = imageY;
	}
	
	public void makeDamageNumber() {
		
		for (int i = 0; i < im.length; i++) {
			im[i] = Toolkit.getDefaultToolkit().getImage(
					getClass().getClassLoader().getResource("image/number/" + animalName + "/" + damageNumber + "/position" + i + ".png"));
		}
			
		damageNumberMotion();
		
	}
	
	private void damageNumberMotion() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (count < im.length) {
					count++;
					setArrayNum(1);
				} else {
					remove();
					timer.cancel();
				}
			}
		};

		count = 0;
		timer.schedule(task, 0, 80);
	}
	
	public void remove() {
		PlayUI.getDisplayComponent().getDamageNumber().remove(this);
	}
	
	public Image getIm() {
		return im[arrayNum];
	}
	
	public void setArrayNum(int arrayNum) {
		this.arrayNum += arrayNum;
		this.arrayNum %= 8;
	}
	
	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}

}
