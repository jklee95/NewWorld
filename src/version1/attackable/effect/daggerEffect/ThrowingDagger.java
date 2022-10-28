package attackable.effect.daggerEffect;

import gui.mainUI.roundUI.PlayUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import attackable.AttackArea;
import attackable.effect.Effect;
import displayComponent.displayObject.DisplayObject;
import displayComponent.displayObject.animal.Animal;
import displayComponent.displayObject.animal.Character;

public class ThrowingDagger extends Effect {  /// %%%%%%%%%%%%% effect 클래스 정리 및 물리공격 스킬 분류 성공함 %%%%%%%%%%%
	
	private Image[][][] im = new Image[1][4][3];
	private String[] fileDirectory = new String[]{"", "/throwingDagger"};
	private String defaultDirectory = "image/character/attack/dagger";

	private int imageX;
	private int imageY;
	private int arrayNum;
	private int positionNum;
	private int motionNum;
	private int count;
	
	private int arrowNum;
	
	public ThrowingDagger(int attackPower, int attackPowerPer, int attackCount, int arrowNum) {
		
		super(attackPower, attackPowerPer, attackCount);
		
		Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		this.imageX = ch.getImageX();
		this.imageY = ch.getImageY();
		this.positionNum = ch.getPositionNum();
		this.arrowNum = arrowNum;
		
		this.attackDistance = 1; // 지우기
		
		for (int i = 0; i < im.length; i++) {
			for (int j = 0; j < im[i].length; j++) {
				for (int k = 0; k < im[i][j].length; k++) {
					URL url = getClass().getClassLoader().getResource(defaultDirectory + fileDirectory[arrowNum] + "/position" + (j + 1) + (k + 1) + ".png");
					im[i][j][k] = Toolkit.getDefaultToolkit().getImage(url);
				}
			}
		}
	}
	

	public void attackAreaPlus(Animal animal) {
		
		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] += ATTACK;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = animal;
		
	}

	public void attackAreaMinus(Animal animal) {
		
		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] -= ATTACK;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = null;
	}
	
	
	public void attackAreaHitTest(Animal attacker) {
		
		Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		this.attackAreaCenterX = ch.getHitAreaCenterX();
		this.attackAreaCenterY = ch.getHitAreaCenterY();
		
		int positionNum = ch.getPositionNum();
		
		
		Timer timer = new Timer();
    	TimerTask task = new TimerTask() {
			@Override
			public void run() {

				if (count++ == 0) AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]++;
				
				if (count % 2 == 0) {
					throwingTest(attacker, timer, positionNum);
				}
				

				switch (positionNum) { // 이동 수치값 조정
					case DisplayObject.DOWN : imageY += 16; break; // 아래
					case DisplayObject.LEFT : imageX -= 16; break; // 왼쪽
					case DisplayObject.RIGHT : imageX += 16; break; // 오른쪽
					case DisplayObject.UP : imageY -= 16; break; // 위
				}
				setMotionNum(1);
				
			}
    	};
    	
    	timer.schedule(task, 0, 40);
	
	}
	
	public void throwingTest(Animal attacker, Timer timer, int positionNum) {

		
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]--;
		
		// ??? 정리???
		switch (positionNum) {
			case DisplayObject.DOWN : attackAreaCenterY += attackDistance; break;
			case DisplayObject.LEFT : attackAreaCenterX -= attackDistance; break;
			case DisplayObject.RIGHT : attackAreaCenterX += attackDistance; break;
			case DisplayObject.UP : attackAreaCenterY -= attackDistance; break;
		}
		
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]++;
		
		if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY] > ATTACK_VALUE) {
			
			if (arrowNum == 0) {
				AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]--;
				remove();
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY], this, AttackArea.MAGICAL, attackCount);
				timer.cancel();
			} else if (arrowNum == 1) {
				if (AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY] == null){
					AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]--;
					remove();
					timer.cancel();
				} else {
					AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY], this, AttackArea.MAGICAL, attackCount);
				}
			}
		}
	}
	
	public void remove() {
		PlayUI.getDisplayComponent().getEffect().remove(this);
	}

	
	public Image getIm() {
		return im[arrayNum][positionNum][motionNum];
	}

	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}

	public void setMotionNum(int motionNum) {
		this.motionNum += motionNum;
		this.motionNum %= 3;
	}


	

}
