package attackable.skill.monsterSkill.crowSkill;

import attackable.AttackArea;
import attackable.skill.activeSkill.normalSkill.NormalActiveSkill;
import attackable.skill.activeSkill.specialSkill.PhysicalActiveSkill;
import displayComponent.displayObject.DisplayObject;
import displayComponent.displayObject.animal.Animal;

public class CrowNormal extends NormalActiveSkill {
	
	public CrowNormal(int physicalAttackPower) {
		this.attackPower = physicalAttackPower;
		this.attackDistance = 0;
	}
	
	public void attackAreaPlus(Animal animal) {
		
		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaDistance(animal, this);
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] += ATTACK_VALUE;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = animal;
		
		AttackArea.attackAreaArray[attackAreaCenterX - 1][attackAreaCenterY]++;
		AttackArea.attackAreaArray[attackAreaCenterX + 1][attackAreaCenterY]++;
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY - 1]++;
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY + 1]++;
		
	}

	public void attackAreaMinus(Animal animal) {

		int hitAreaCenterX = animal.getHitAreaCenterX();
		int hitAreaCenterY = animal.getHitAreaCenterY();
		
		AttackArea.attackAreaDistance(animal, this);
		
		AttackArea.attackAreaArray[hitAreaCenterX][hitAreaCenterY] -= ATTACK_VALUE;
		AttackArea.attackAnimalArray[hitAreaCenterX][hitAreaCenterY] = null;
		
		AttackArea.attackAreaArray[attackAreaCenterX - 1][attackAreaCenterY]--;
		AttackArea.attackAreaArray[attackAreaCenterX + 1][attackAreaCenterY]--;
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY - 1]--;
		AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY + 1]--;
	}
	
	public void attackAreaHitTest(Animal attacker) {

		int motionNum = attacker.getMotionNum();
		
		if (motionNum == 2) {
			
			
			if (AttackArea.attackAreaArray[attackAreaCenterX - 1][attackAreaCenterY] > ATTACK) {
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX - 1][attackAreaCenterY], this, AttackArea.PHYSICAL, 1);
			}
			if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY - 1] > ATTACK) {
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY - 1], this, AttackArea.PHYSICAL, 1);
			}
			if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY + 1] > ATTACK) {
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX][attackAreaCenterY + 1], this, AttackArea.PHYSICAL, 1);
			}
			if (AttackArea.attackAreaArray[attackAreaCenterX + 1][attackAreaCenterY]> ATTACK) {
				AttackArea.attack(attacker, AttackArea.attackAnimalArray[attackAreaCenterX + 1][attackAreaCenterY], this, AttackArea.PHYSICAL, 1);
			}
			
			
			
		}
	}
	
	public boolean attackAreaBooleanTest(Animal animal) {
		
		if (AttackArea.attackAreaArray[attackAreaCenterX - 1][attackAreaCenterY] > ATTACK) {
			animal.setPositionNum(DisplayObject.LEFT);
			return true;
		} else if (AttackArea.attackAreaArray[attackAreaCenterX + 1][attackAreaCenterY] > ATTACK) {
			animal.setPositionNum(DisplayObject.RIGHT);
			return true;
		} else if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY - 1] > ATTACK) {
			animal.setPositionNum(DisplayObject.UP);
			return true;
		} else if (AttackArea.attackAreaArray[attackAreaCenterX][attackAreaCenterY + 1] > ATTACK) {
			animal.setPositionNum(DisplayObject.DOWN);
			return true;
		}
		
		return false;
	}
}
