package displayComponent.displayObject.animal;

import gui.mainUI.roundUI.PlayUI;
import item.weapon.characterWeapon.CharacterWeapon;
import item.weapon.characterWeapon.dagger.Dagger;
import item.weapon.characterWeapon.etc.Blank;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import displayComponent.displayObject.Movable;


public class Character extends Animal implements KeyListener {
	
	// 기본 능력치 필드
	private int maxExp;
	
	private int skillPoint = 13;
	private int abilityPoint;

	private boolean[] keyPushBoolean = { false, false, false, false, false, false, false, false, false }; // 키 불룬값
	private Thread thread;
	private Timer attackTimer;
	private CharacterWeapon weapon;
	private int weaponType;
	
	/*
	private Sword sword;
	private Dagger dagger;
	private Hammer hammer;
	private Bow bow;
	*/
	
	int key = 0;
	boolean key2 = true;

	public Character(int imageX, int imageY) {
		
		this.fileDirectory = new String[]{"move", "attack/sword", "attack/dagger", "attack/bow", "attack/hammer"};
		this.defaultDirectory = "image/character/";
		this.skillDirectory = new String[]{"/normal", "/skill1", "/skill2", "/skill3"};
		this.weaponType = 0;

		for (int i = 0; i < im.length; i++) {
			for (int j = 0; j < im[i].length; j++) {
				for (int k = 0; k < im[i][j].length; k++) {
					for (int l = 0; l < im[i][j][k].length; l++) {
						
						this.directory = defaultDirectory + fileDirectory[i] + skillDirectory[j] + "/position" + (k + 1) + (l + 1) + ".png";
						
						if ((url = getClass().getClassLoader().getResource(directory)) != null) {
							im[i][j][k][l] = Toolkit.getDefaultToolkit().getImage(url);
						} else break;
					}
				}
			}
		}
		
		this.maxHp = 100;
		this.hp = maxHp;
		this.maxMp = 100;
		this.mp = maxMp;
		this.maxExp = 50;
		this.exp = 0;
		this.level = 1;
		this.physicalAttackPower = 5;
		this.physicalDefensePower = 5;
		this.magicalAttackPower = 5;
		this.accuracyRate = 100;
		this.evasionRate = 30;
		this.gold = 100;

		this.imageX = imageX;
		this.imageY = imageY;
		this.hitAreaCenterX += imageX / (MOVE_VALUE * STOP_VALUE) + (BG_BLOCK / 2);
		this.hitAreaCenterY += imageY / (MOVE_VALUE * STOP_VALUE) + (BG_BLOCK / 2);
		
		hitAreaPlus();
		areaLimit();
		
		/*
		this.sword = new Sword("초보검", 20, 1);
		this.dagger = new Dagger("초보단검", 10, 5);
		this.hammer = new Hammer("초보망치", 30, 20);
		this.bow = new Bow("초보활", 5, 10);
		*/

		this.weapon = new Blank();
		weapon.attackAreaPlus(this);

	}
	
	public void weaponChange(CharacterWeapon weapon) {
		this.weapon.attackAreaMinus(this);
		this.weapon = weapon;
		this.weaponType = weapon.getWeaponType();
		this.attackSpeed = ACT_SPEED + weapon.getWeaponSpeed();
		this.weapon.attackAreaPlus(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == LEFT_ARROW) keyPushBoolean[LEFT] = true;
		else if (e.getKeyCode() == UP_ARROW) keyPushBoolean[UP] = true;
		else if (e.getKeyCode() == RIGHT_ARROW) keyPushBoolean[RIGHT] = true;
		else if (e.getKeyCode() == DOWN_ARROW) keyPushBoolean[DOWN] = true;
		
		if (e.getKeyCode() == SPACEBAR) keyPushBoolean[4] = true;
		else if (e.getKeyCode() == CTRL) keyPushBoolean[5] = true;
		else if (e.getKeyCode() == A) keyPushBoolean[6] = true;
		else if (e.getKeyCode() == S) keyPushBoolean[7] = true;
		else if (e.getKeyCode() == D) keyPushBoolean[8] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == LEFT_ARROW) keyPushBoolean[LEFT] = false;
		else if (e.getKeyCode() == UP_ARROW) keyPushBoolean[UP] = false;
		else if (e.getKeyCode() == RIGHT_ARROW) keyPushBoolean[RIGHT] = false;
		else if (e.getKeyCode() == DOWN_ARROW) keyPushBoolean[DOWN] = false;
		
		if (e.getKeyCode() == SPACEBAR) keyPushBoolean[4] = false;
		else if (e.getKeyCode() == CTRL) {
			keyPushBoolean[5] = false;
			key2 = true;
		}
		else if (e.getKeyCode() == A) keyPushBoolean[6] = false;
		else if (e.getKeyCode() == S) keyPushBoolean[7] = false;
		else if (e.getKeyCode() == D) keyPushBoolean[8] = false;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public void hitTest() throws InterruptedException {

		// 왼쪽
		if (keyPushBoolean[LEFT] == true) {
			if (hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY] < BLOCK) {
				
				this.setXY(hitAreaCenterX - 1, hitAreaCenterY, LEFT);
			
				moveMotion(); // 이동
				synchronized (thread) {
					thread.wait();
				}
			} else if (hitAreaArray[hitAreaCenterX - 1][hitAreaCenterY] >= BLOCK) {
				this.setPosition(LEFT);
			}
		}
			

		// 위
		if (keyPushBoolean[UP] == true) {
			if (hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1] < BLOCK) {
				
				this.setXY(hitAreaCenterX, hitAreaCenterY - 1, UP);

				moveMotion();
				synchronized (thread) {
					thread.wait();
				}
			} else if (hitAreaArray[hitAreaCenterX][hitAreaCenterY - 1] >= BLOCK) {
				this.setPosition(UP);
			}
		}
			

		// 오른쪽
		if (keyPushBoolean[RIGHT] == true) {
			if (hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY] < BLOCK) {
				
				this.setXY(hitAreaCenterX + 1, hitAreaCenterY, RIGHT);

				moveMotion();
				synchronized (thread) {
					thread.wait();
				}
			} else if (hitAreaArray[hitAreaCenterX + 1][hitAreaCenterY] >= BLOCK) {
				this.setPosition(RIGHT);
			}
		}
			 

		// 아래
		if (keyPushBoolean[DOWN] == true) {
			if (hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1] < BLOCK) {
				
				this.setXY(hitAreaCenterX, hitAreaCenterY + 1, DOWN);
	
				moveMotion();
				synchronized (thread) {
					thread.wait();
				}
			} else if (hitAreaArray[hitAreaCenterX][hitAreaCenterY + 1] >= BLOCK) {
				this.setPosition(DOWN);
			}
		}
		
		// 스페이스 바
		if (keyPushBoolean[4] == true || keyPushBoolean[6] == true || keyPushBoolean[7] == true) {
			
			if (weaponType != 0) {

				int tempSkillNum = 0;
				
				if (keyPushBoolean[4]) tempSkillNum = 0;
				else if (keyPushBoolean[6]) tempSkillNum = 1;
				else if (keyPushBoolean[7]) tempSkillNum = 2;
				
				
				// 스킬 레벨 및 마력 테스트 
				if (tempSkillNum != 0) {
					if (Dagger.getSkillArray()[tempSkillNum - 1].getSkillLevelCurrent() != 0) {
						if (mp - weapon.getDecreaseMp(tempSkillNum) >= 0) { // ???? weapon에서 엠피를 가져온다 --- 수정요망
							mp -= weapon.getDecreaseMp(tempSkillNum);
							 
							skillNum = tempSkillNum;
							
							arrayNum += weaponType;
							attackMotion();
							
							synchronized (thread) {
								thread.wait();
							}   
						} else {
							System.out.println("mp가 부족행");
						}
					} else {
						System.out.println("레벨이 모자라");
					}
				} else {
					skillNum = tempSkillNum;
					
					arrayNum += weaponType;
					attackMotion();
					
					synchronized (thread) {
						thread.wait();
					}  
				}
				
				/*
				// 몬스터 공격
				for (int i = 1; i <= weapon.getWeaponRange(); i++) {
						if (positionNum == DOWN && attackAreaArray[attackAreaCenterX][attackAreaCenterY + i] >= BLOCK) { 
							attack(attackAnimalArray[attackAreaCenterX][attackAreaCenterY + i][0]);
						} else if (positionNum == UP && attackAreaArray[attackAreaCenterX][attackAreaCenterY - i] >= BLOCK) {
							attack(attackAnimalArray[attackAreaCenterX][attackAreaCenterY - i][0]);
						} else if (positionNum == RIGHT && attackAreaArray[attackAreaCenterX + i][attackAreaCenterY] >= BLOCK) {
							attack(attackAnimalArray[attackAreaCenterX + i][attackAreaCenterY][0]);
						} else if (positionNum == LEFT && attackAreaArray[attackAreaCenterX - i][attackAreaCenterY] >= BLOCK) {
							attack(attackAnimalArray[attackAreaCenterX - i][attackAreaCenterY][0]);
						}
					
					
				}
				*/
			} else {
				System.out.println("장착된 무기가 없습니다.");
			}

		}
		
		/*
		if (keyPushBoolean[5] == true && key2 == true) {
			key++;
			
			switch (key) {
			case 1 : requiredLv(dagger.getRequiredLevel(), dagger);
				break;
			case 2 : requiredLv(bow.getRequiredLevel(), bow);
				break;  
 			case 3 : requiredLv(hammer.getRequiredLevel(), hammer);
				break;
			default:
				weaponChange(sword);   
				weaponType = 1;
				key = 0;       
				break;
			}
			key2 = false;
		}
		*/
		//test();
		//Weapon.test();

	}
	
	/*
	public void requiredLv(int level, CharacterWeapon weapon) {
		if (this.level >= level) {
			weaponChange(weapon);
			weaponType++;
		} else {
			weaponChange(sword);
			weaponType = 1;
			key = 0;
		}
		
	}
	*/

	public void moveMotion() {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				
				if (count < STOP_VALUE) {
					switch (positionNum) { // 이동 수치값 조정
					case DOWN: imageY += MOVE_VALUE; break;
					case LEFT: imageX -= MOVE_VALUE; break;
					case RIGHT: imageX += MOVE_VALUE; break;
					case UP: imageY -= MOVE_VALUE; break;
					}
					setMotionNum(1); // 모션
					count++;

				} else {
					timer.cancel();
					synchronized (thread) {
						thread.notify(); // 스레드 재시작
					}

				}
			}
		};

		count = 0;
		timer.schedule(task, 0, ACT_SPEED);
		
	}

	public void attackMotion() {

		attackTimer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {

				motionNum++;
				attack();
				
				if (im[arrayNum][skillNum][positionNum][motionNum] != null) {
				} else {
					arrayNum = 0;
					skillNum = 0;
					motionNum = 0;
					
					attackTimer.cancel();
					synchronized (thread) {
						thread.notify(); // 스레드 재시작
					}

				}
			}
		};

		count = 0;
		attackTimer.schedule(task, 0, attackSpeed);
	}
	
	public void attack() {
		weapon.attackAreaHitTest(this);
	}

	public Image getIm() {
		return im[arrayNum][skillNum][positionNum][motionNum];
	}

	public void setMotionNum(int motionNum) {
		this.motionNum += motionNum;
		this.motionNum %= 4;
	}
	
	public int getSkillNum() {
		return this.skillNum;
	}

	@Override
	public void death() {
		
	}

	public int getMaxHp() {
		return maxHp;
	}
	
	public int getMaxMp() {
		return maxMp;
	}
	
	public int getMaxExp() {
		return maxExp;
	}

	
	public void setExp(int exp){
		this.exp += exp;
		
		if (maxExp <= this.exp) {
			this.abilityPoint += 5;
			this.skillPoint += 3; 
			level++;
			
			this.exp -= maxExp;
			maxExp += 2 * level;
			
			maxHp += 2 * level;
			this.hp = maxHp;
			maxMp += 2 * level;
			this.mp = maxMp;
			
		}
	}
	
	public void setKeyBooleanReset() {
		for (int i = 0; i < keyPushBoolean.length; i++) {
			keyPushBoolean[i] = false; 
		}
	}
	
	public void setXY(int imageX, int imageY) {
		
		hitAreaMinus();
		weapon.attackAreaMinus(this);
		this.imageX = imageX;
		this.imageY = imageY;
		this.hitAreaCenterX = imageX / (MOVE_VALUE * STOP_VALUE) + (BG_BLOCK / 2) + (EXTRA_ARRAY / 2);
		this.hitAreaCenterY = imageY / (MOVE_VALUE * STOP_VALUE) + (BG_BLOCK / 2) + (EXTRA_ARRAY / 2);
		positionNum = DOWN;
		hitAreaPlus();
		weapon.attackAreaPlus(this);
		
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
	
	public void setPosition(int positionNum) {
		weapon.attackAreaMinus(this);
		this.positionNum = positionNum; // 캐릭터 방향 결정
		weapon.attackAreaPlus(this);
	}
	
	public void makeThread() {

		
		this.thread = new Thread(new Runnable() {
			
			private boolean threadFlag = true;
			
			@Override
			public void run() {
				
				while (threadFlag) {

					try {
						hitTest(); // 키값 지속 확인
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					if (PlayUI.getDisplayComponent().getMonster().size() <= 0) {
						stop();
					}
					
					try {
						thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			public void stop() {
				threadFlag = false;
			}
		});
		thread.start();
		
	}

	public Timer getAttackTimer() {
		return attackTimer;
	}

	public int getAbilityPoint() {
		return abilityPoint;
	}

	public void setAbilityPoint(int abilityPoint) {
		this.abilityPoint += abilityPoint;
	}

	
	public int getSkillPoint() {
		return skillPoint;
	}

	public void setSkillPoint(int skillPoint) {
		this.skillPoint += skillPoint;
	}
	

	public CharacterWeapon getWeapon() {
		return weapon;
	}
	

	public void setPhysicalAttackPower(int physicalAttackPower) {
		this.physicalAttackPower += physicalAttackPower;
	}

	public void setPhysicalDefensePower(int physicalDefensePower) {
		this.physicalDefensePower += physicalDefensePower;
	}

	public void setMagicalAttackPower(int magicalAttackPower) {
		this.magicalAttackPower += magicalAttackPower;
	}

	public void setMagicalDefensePower(int magicalDefensePower) {
		this.magicalDefensePower += magicalDefensePower;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp += 20 * maxHp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp += 20 * maxMp;
	}
	
	
	

}
