package attackable.skill.characterSkill.swordSkill;

import attackable.AttackArea;
import attackable.skill.activeSkill.normalSkill.NormalActiveSkill;
import displayComponent.displayObject.animal.Animal;

public class SwordNormal extends NormalActiveSkill {
	
	public SwordNormal(int physicalAttackPower) {
		this.attackPower = physicalAttackPower;
		this.attackDistance = 1;
	}
	
	
	public void attackAreaPlus(Animal animal) {
		
		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaDistance(animal, this);
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] += ATTACK;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = animal;
		
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]++;
		
	}

	public void attackAreaMinus(Animal animal) {
		
		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaDistance(animal, this);
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] -= ATTACK;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = null;
		
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY]--;
	}
	
	public void attackAreaHitTest(Animal attacker) {
		
		int motionNum = attacker.getMotionNum();
		
		if (motionNum == 3) {
			
			
			if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY] > ATTACK_VALUE) {
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY], this, AttackArea.PHYSICAL, 1);
			}
			
			
			
			
		}
	}
}
