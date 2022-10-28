package displayComponent.damage;

import gui.mainUI.roundUI.PlayUI;

import java.util.Timer;
import java.util.TimerTask;

public class TotalDamageNumber {
	
	private int damageNumber;
	private String animalName;
	private int imageX;
	private int imageY;
	private int index;
	
	
	public TotalDamageNumber(int damageNumber, String animalName, int imageX, int imageY) {
		this.damageNumber = damageNumber;
		this.animalName = animalName;
		this.imageX = imageX;
		this.imageY = imageY;
	}
	
	public void makeDamageNumber(int count) {
		
		char[] number = Integer.toString(damageNumber).toCharArray();
		
		if (number[0] == '-') {
			addDamageNumber('-', count);
		} else {
			for (int i = number.length - 1; i >= 0; i--) {
				addDamageNumber(number[i], count);
			}
		}			
		
	}
	
	public void addDamageNumber(char inputChar, int count) {
		DamageNumber damage = new DamageNumber(inputChar, animalName, imageX - (index++ * 9), imageY - (10 * count));
		PlayUI.getDisplayComponent().getDamageNumber().add(damage);
		damage.makeDamageNumber();
	}

}
