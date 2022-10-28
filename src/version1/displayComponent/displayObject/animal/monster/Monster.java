package displayComponent.displayObject.animal.monster;

import gui.mainUI.roundUI.PlayUI;
import item.weapon.monsterWeapon.Crow;
import item.weapon.monsterWeapon.LongCrow;
import item.weapon.monsterWeapon.MonsterWeapon;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import displayComponent.DisplayComponent;
import displayComponent.displayObject.Movable;
import displayComponent.displayObject.animal.Animal;


public abstract class Monster extends Animal {
	
	protected static final int DEFAULT_HP_BAR = 50;
	
	protected String monsterDirectory;
	
	
	/*
	private int maxMagicalAttackPower;
	private int maxPhysicalDefensePower;
	private int maxMagicalDefensePower;
	private int maxAccuracyRate;
	private int maxEvasionRate;
	private int maxExp;
	*/
	
	protected int hpBar;

	protected Timer timer;
	protected TimerTask task;
	protected int speed;
	
	protected MonsterWeapon weapon;
	
	protected boolean hitFlag; 
	
	public void setDefault(int imageX, int imageY) {
		
		this.fileDirectory = new String[]{"/move", "/attack"};
		this.defaultDirectory = "image/monster/";
		this.monsterDirectory = this.getClass().getSimpleName().toLowerCase();
		this.skillDirectory = new String[]{"/normal"};
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 1; j++) {
				for (int k = 0; k < im[i][j].length; k++) {
					for (int l = 0; l < im[i][j][k].length; l++) {

						this.directory = defaultDirectory + monsterDirectory + fileDirectory[i] + skillDirectory[j] + "/position" + (k + 1) + (l + 1) + ".png";
						
						if ((url = getClass().getClassLoader().getResource(directory)) != null) {
							im[i][j][k][l] = Toolkit.getDefaultToolkit().getImage(url);
						}
					}
				}
			}
		}

		
		this.imageX = imageX;
		this.imageY = imageY;
		this.hitAreaCenterX += imageX / (MOVE_VALUE * STOP_VALUE) + 1;
		this.hitAreaCenterY += imageY / (MOVE_VALUE * STOP_VALUE) + 1;
		hitAreaPlus();
		//attackAreaPlus(1, 0);

		weaponChange(weapon);
		weapon.attackAreaPlus(this);
		
		this.speed = (int)(Math.random()*1000 + 1000);
		makeThread();
		
	}
	
	public void weaponChange(MonsterWeapon weapon) {
		weapon.attackAreaMinus(this);
		this.weapon = weapon;
		this.attackSpeed = ACT_SPEED + weapon.getWeaponSpeed();
		weapon.attackAreaPlus(this);
	}
	
	public void attackMotion() {
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (count < STOP_VALUE) {
					setMotionNum(1);
					count++;
					
					attack();

				} else {
					timer.cancel();
				}
			}
		};

		count = 0;
		timer.schedule(task, 0, ACT_SPEED);

	}
	
	public void attack() {
		weapon.attackAreaHitTest(this);
	}
	
	public void hitTest() throws InterruptedException {
		
		
		
		// 공격!
		
		// 공격!
		if (weapon.attackAreaBooleanTest(this)) {
			attackMotion();
			hitFlag = true;
		} else {
			hitFlag = false;
		}
				
		
		/*
		if (hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1] >= BLOCK) { 
			positionNum = DOWN;
			randomPosition = -1;

			attackMotion(dc);
		} else if (hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1] >= BLOCK) {
			positionNum = UP;
			randomPosition = -1;

			attackMotion(dc);
		} else if	(hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY] >= BLOCK) {
			positionNum = RIGHT;
			randomPosition = -1;

			attackMotion(dc);
		} else if (hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY] >= BLOCK) {
			positionNum = LEFT;
			randomPosition = -1;

			attackMotion(dc);
		}
		
		
		
		if ((hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1] >= BLOCK
						|| hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1] >= BLOCK
						|| hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY] >= BLOCK 
						|| hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY] >= BLOCK)) {
			
			arrayNum = ATTACK_ARRAY_NUM + randomPosition;
			randomPosition = -1;

			attack(dc);

		} else {
			arrayNum = randomPosition; // 방향 결정
		}*/
		
		boolean leftRight = false;
		boolean upDown = false;
		
		
		while (true) { // 방향선택 무작위로 멈춤효과 방지 위해 반복문 설계

			if (leftRight  == true && upDown == true) {
				System.out.println(leftRight);
				System.out.println(upDown);
				System.out.println("stop");
				break;
			}
			
			if (hitFlag == false){
				if (Math.random() < 0.5) { // 상하, 좌우 이동선택 무작위 
					// 왼쪽
					if (PlayUI.getDisplayComponent().getCharacter().getImageX() < this.imageX && 
							hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY] < BLOCK) {
						
						this.setXY(hitAreaCenterX - 1, hitAreaCenterY, LEFT);
						
						moveMotion();// 이동
						break;
					}
					// 오른쪽
					else if (PlayUI.getDisplayComponent().getCharacter().getImageX() > this.imageX && 
							hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY] < BLOCK) {
						
						this.setXY(hitAreaCenterX + 1, hitAreaCenterY, RIGHT);
						
						moveMotion();
						break;
					}
					leftRight = true;
				}
				
				else {
					// 위
					if (PlayUI.getDisplayComponent().getCharacter().getImageY() < this.imageY && 
							hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1] < BLOCK) {
						
						this.setXY(hitAreaCenterX, hitAreaCenterY - 1, UP);
						
						moveMotion();
						break;
					}
					// 아래
					else if (PlayUI.getDisplayComponent().getCharacter().getImageY() > this.imageY && 
							hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1] < BLOCK){
						
						this.setXY(hitAreaCenterX, hitAreaCenterY + 1, DOWN);
						
						moveMotion();
						break;
					}
					upDown = true;
				}

			} else break; // 공격 중일땐 탈출
		}
	}
	
	
	public void moveMotion() {

		Timer timer = new Timer();
    	TimerTask task = new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if (count < STOP_VALUE) {
					switch (positionNum) { // 이동 수치값 조정
					case DOWN : imageY += MOVE_VALUE; break; // 아래
					case LEFT : imageX -= MOVE_VALUE; break; // 왼쪽
					case RIGHT : imageX += MOVE_VALUE; break; // 오른쪽
					case UP : imageY -= MOVE_VALUE; break; // 위
					}
					setMotionNum(1);
					count ++;
					
				} else {
					timer.cancel();
				}
			}
    	};
    	
    	count = 0;
    	timer.schedule(task, 0, ACT_SPEED);
	
	}
	
	public void makeThread() {

		timer = new Timer();
		task = new TimerTask() {
			
			
			public void run() {
				
				try {
					hitTest();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		timer.schedule(task, 0, speed); // 무작위 이동
		
	}
	
	
	public Image getIm() {
		return im[arrayNum][skillNum][positionNum][motionNum];
	}
	
	public int getArrayNum() {
		return arrayNum;
	}

	public void setMotionNum(int motionNum) {
		this.motionNum += motionNum;
		this.motionNum %= 4;
	}           
	
	public void setPositionNum(int positionNum) {
		this.positionNum = positionNum;
	}
	
	public void death() {
		this.timer.cancel();
		this.hitAreaMinus();
		weapon.attackAreaMinus(this);
	}
	

	public int getHpBar() {
		return hpBar;
	}

	public void setHpBar() {
		this.hpBar = (int)(((float)hp / (float)maxHp) * DEFAULT_HP_BAR);
	}
	

	
	public void setXY(int hitAreaCenterX, int hitAreaCenterY, int positionNum) {
		
		hitAreaMinus(); // 범위 이동 
		weapon.attackAreaMinus(this);
		this.hitAreaCenterX = hitAreaCenterX;
		this.hitAreaCenterY = hitAreaCenterY;
		this.positionNum = positionNum;  // 캐릭터 방향 결정
		hitAreaPlus();
		weapon.attackAreaPlus(this);
		
	}
	

	public MonsterWeapon getWeapon() {
		return weapon;
	}

	public Timer getTimer() {
		return timer;
	}
	
	



}
