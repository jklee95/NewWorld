package attackable.effect.daggerEffect;

import gui.mainUI.roundUI.PlayUI;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import attackable.AttackArea;
import attackable.effect.Effect;
import displayComponent.displayObject.animal.Animal;
import displayComponent.displayObject.animal.monster.Monster;

public class Slash extends Effect {
	
	private Image[] im = new Image[30];
	private String[] fileDirectory = new String[]{"normal", "final"};
	private String defaultDirectory = "image/character/attack/dagger/skill2/slash/";
	
	public static Monster[] tempMonsterArray = new Monster[6];
	private int imageX = 100;
	private int imageY = 100;
	private int motionNum;
	private int count;
	
	public Slash(int attackPower, int attackPowerPer, int attackCount, int slashNum) {
		
		super(attackPower, attackPowerPer, attackCount);
		
		for (int i = 0; i < im.length; i++) {
			URL url;
			if ((url = getClass().getClassLoader().getResource(defaultDirectory + fileDirectory[slashNum] + "/position" + (i + 1) + ".png")) != null) {
				im[i] = Toolkit.getDefaultToolkit().getImage(url);
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
		
		Monster monster = checkAttackedMonster();
		
		this.imageX = monster.getImageX();
		this.imageY = monster.getImageY();
		
		
		AttackArea.attack(attacker, monster, this, AttackArea.PHYSICAL, attackCount);
		
		Timer timer = new Timer();
    	TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (im[count] != null) {
					motionNum++;
					count++;
				} else {
					remove();
					
					timer.cancel();
				}
			}
    	};
    	timer.schedule(task, 0, 80);
	}
	
	public void remove() {
		PlayUI.getDisplayComponent().getEffect().remove(this);
	}
	

	
	///// 몬스터 중복 공격 방지
	public Monster checkAttackedMonster() {

		Vector<Monster> monsterVector = PlayUI.getDisplayComponent().getMonster();
		
		
		boolean flag;
		int size = monsterVector.size();
		Monster tempMonster;
		
		/*
		System.out.print("monsterNum = ");
		for (int i=0; i < tempMonsterArray.length; i++) {
			System.out.print(tempMonsterArray[i] + ", ");
		}
		System.out.println("\n");
		*/
		
		
		do {
			flag = false;
			tempMonster = monsterVector.get((int)(Math.random()*size + 0));

			for (int i = 0; ; ) {
				if (tempMonsterArray[i] != null) {
					
					if (tempMonsterArray[i] == tempMonster) {
						tempMonster = monsterVector.get((int)(Math.random()*size + 0));
						i = 0;
					} else i++;
					
				} else {
					tempMonsterArray[i] = tempMonster;
					flag = true;
					break;
				}
			}
			
		} while (!flag);
		
		
		return tempMonster;
	}


	
	public Image getIm() {
		return im[motionNum];
	}

	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}

}
