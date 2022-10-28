package item.weapon.characterWeapon.sword;

import attackable.AttackArea;
import attackable.skill.characterSkill.swordSkill.SwordNormal;
import item.weapon.characterWeapon.CharacterWeapon;
import displayComponent.DisplayComponent;
import displayComponent.displayObject.animal.Animal;

public class Sword extends CharacterWeapon {
	
	private SwordNormal sn;
	
	public Sword(String name, int physicalAttackPower, int requiredLevel){
		this.name = name;
		this.physicalAttackPower = physicalAttackPower;
		this.requiredLevel = requiredLevel;
		this.weaponSpeed = 10;
		
		this.sn = new SwordNormal(this.physicalAttackPower);
		
		this.weaponType = SWORD;
		this.gold = 200;
	}
	
	public void attackAreaPlus(Animal animal) {
		
		sn.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {
		
		sn.attackAreaMinus(animal);
	}
	
	public void attackAreaHitTest(Animal attacker) {
		
		sn.attackAreaHitTest(attacker);
	}
	
}
