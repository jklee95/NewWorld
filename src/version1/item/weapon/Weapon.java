package item.weapon;

import item.Item;
import attackable.Attackable;
import attackable.skill.activeSkill.ActiveSkill;

public abstract class Weapon extends Item implements Attackable {
	
	

	protected static final int BLANK = 0;
	protected static final int SWORD = 1;
	protected static final int DAGGER = 2;
	protected static final int BOW = 3;
	protected static final int HAMMER = 4;
	
	
	protected int physicalAttackPower;
	protected int magicalAttackPower;
	protected int weaponSpeed;
	
	
	/*
	public void death(Animal animal, DisplayComponent dc) {

		animal.setHpBar();
		
		if (animal.getHp() <= 0) {
			dc.getMonster().remove(animal);
			animal.death();
			dc.getCh().setExp(animal.getExp());
			dc.repaint();
		}
		
	}*/
	
	
	
	public int getWeaponSpeed() {
		return weaponSpeed;
	}

	public int getPhysicalAttackPower() {
		return physicalAttackPower;
	}
	
	
	public int getMagicalAttackPower() {
		return magicalAttackPower;
	}

	// 스워드도 스킬 만드면 추상으로 바꿔야할 듯
	public int getDecreaseMp(int skillNum) {
		return 0;
	}
	


	
}
