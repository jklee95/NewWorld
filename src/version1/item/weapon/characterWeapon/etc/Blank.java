package item.weapon.characterWeapon.etc;

import attackable.AttackArea;
import attackable.skill.characterSkill.daggerSkill.SkillManager;
import displayComponent.displayObject.animal.Animal;
import item.weapon.characterWeapon.CharacterWeapon;

public class Blank extends CharacterWeapon {
	
	public Blank() {
		this.weaponType = BLANK;
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
		
	}

	@Override
	public void skillChange(int skillNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SkillManager smChange(int skillNum) {
		// TODO Auto-generated method stub
		return null;
	}
}
