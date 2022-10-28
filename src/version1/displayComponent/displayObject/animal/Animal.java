package displayComponent.displayObject.animal;

import item.weapon.Weapon;

import java.awt.Image;
import java.net.URL;

import displayComponent.displayObject.DisplayObject;
import displayComponent.displayObject.Movable;

public abstract class Animal extends DisplayObject implements Movable {

	// 출력 필드
	protected String[] fileDirectory;
	protected String[] skillDirectory;
	protected String defaultDirectory;
	protected String directory;
	protected Image[][][][] im = new Image[5][4][4][100];
	protected URL url;
	protected int imageX;
	protected int imageY;
	protected int arrayNum;
	protected int skillNum;
	protected int positionNum;
	protected int motionNum;
	protected int count;

	// 능력치 필드
	protected String name;
	protected int level;
    protected int hp;
    protected int mp;
    protected int maxHp;
    protected int maxMp;
    protected int physicalAttackPower;
    protected int physicalDefensePower;
    protected int magicalAttackPower;
	protected int magicalDefensePower;
    protected int accuracyRate;
    protected int evasionRate;
    protected int exp;
    protected int attackSpeed;
    protected int attackRange;
    protected int gold;
    
    
    
    public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold += gold;
	}

	public void setHpBar() {
    	
    }
	
	public abstract Weapon getWeapon();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp += hp;
		if (this.hp > maxHp) this.hp = maxHp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public void setMp(int mp){
		this.mp += mp;
		if (this.mp > maxMp) this.mp = maxMp;
	}
	
	public void setPositionNum(int positionNum) {
		// TODO Auto-generated method stub
		
	}
	
	public int getExp() {
		return exp;
	}

	
	public int getLv() {
		return level;
	}
	
	public int getPhysicalAttackPower() {
		return physicalAttackPower;
	}
	
	public int getPhysicalDefensePower() {
		return physicalDefensePower;
	}
	
	public int getMagicalAttackPower() {
		return magicalAttackPower;
	}

	public int getMagicalDefensePower() {
		return magicalDefensePower;
	}

	public int getAccuracyRate() {
		return accuracyRate;
	}

	public int getEvasionRate() {
		return evasionRate;
	}

	public abstract void death();
	


	public int getImageX() {
		return imageX;
	}

	public int getImageY() {
		return imageY;
	}
	
	
	

	
	public int getMotionNum() {
		return motionNum;
	}
	
	public int getPositionNum() {
		return positionNum;
	}
	

}
