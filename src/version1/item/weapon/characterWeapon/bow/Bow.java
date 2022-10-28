package item.weapon.characterWeapon.bow;

import attackable.skill.characterSkill.bowSkill.BowNormal;
import attackable.skill.characterSkill.bowSkill.BowSkill1;
import attackable.skill.characterSkill.bowSkill.BowSkill2;
import attackable.skill.characterSkill.daggerSkill.SkillManager;
import displayComponent.DisplayComponent;
import displayComponent.displayObject.animal.Animal;
import gui.mainUI.roundUI.PlayUI;
import item.weapon.characterWeapon.CharacterWeapon;

public class Bow extends CharacterWeapon {
	
	private SkillManager bsm;
	private BowNormal bn;
	
	private static BowSkill1 bk1 = new BowSkill1(0);
	private static BowSkill2 bk2 = new BowSkill2(0);
	
	public Bow(String name, int physicalAttackPower, int magicalAttackPower, int requiredLevel){
		this.name = name;
		this.requiredLevel = requiredLevel;
		this.weaponSpeed = 0;
		this.physicalAttackPower = physicalAttackPower;
		this.magicalAttackPower = magicalAttackPower;
		
		this.bn = new BowNormal(this.physicalAttackPower);
		this.bsm = bn;
		
		this.weaponType = BOW;
		this.gold = 70;
	}
	

	public void attackAreaPlus(Animal animal) {
		
		bsm.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {
		
		bsm.attackAreaMinus(animal);
	}
	
	
	public void attackAreaHitTest(Animal attacker) {
		
		displayComponent.displayObject.animal.Character ch = PlayUI.getDisplayComponent().getCharacter();
		
		bsm.attackAreaMinus(ch);
		skillChange(ch.getSkillNum());
		bsm.attackAreaPlus(ch);
		
		bsm.attackAreaHitTest(attacker);
		
	}
	
	
	public void attack(Animal animal, DisplayComponent dc, int physicalAttackPower) {
		
	}
	
	public void skillChange(int skillNum) {
		switch (skillNum) {
		case 0 : bsm = bn; break;
		//case 1 : bsm = bk1;	break;
		//case 2 : bsm = bk2; break;
		}

	}
	
	public SkillManager smChange(int skillNum) {
		switch (skillNum) {
		case 0 : return bn;
		//case 1 : return bk1;
		//case 2 : return bk2;
		}
		return null;
	}

	
	
}
