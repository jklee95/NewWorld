package attackable.skill.characterSkill.bowSkill;

import attackable.effect.bowEffect.IceArrow;
import attackable.skill.activeSkill.ActiveSkill;
import item.weapon.characterWeapon.hammer.LongCrack;
import displayComponent.DisplayComponent;
import displayComponent.displayObject.animal.Animal;

public class BowSkill2 extends ActiveSkill implements BowSkillManager {
	
	private IceArrow iceArrow;
	
	public BowSkill2(int physicalAttackPower){
		this.physicalAttackPower = physicalAttackPower;
		this.attackDistance = 1;
		this.decreaseMp = 20;
		this.attackDistance = 7;
	}

	@Override
	public void attackAreaPlus(Animal animal, int positionNum,
			int hitAreaCenterX, int hitAreaCenterY) {
		// TODO Auto-generated method stub
		attackAreaDistance(positionNum, hitAreaCenterX, hitAreaCenterY);
		
		attackAreaArray[hitAreaCenterX][hitAreaCenterY] += ATTACK;

		attackAnimalArray[hitAreaCenterX][hitAreaCenterY][0] = animal;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2 ; j++) {
				attackAreaArray[attackAreaCenterX + j][attackAreaCenterY + i]++;
			}
		}
		
	}

	@Override
	public void attackAreaMinus(int positionNum, int hitAreaCenterX,
			int hitAreaCenterY) {
		// TODO Auto-generated method stub
		attackAreaDistance(positionNum, hitAreaCenterX, hitAreaCenterY);
		
		attackAreaArray[hitAreaCenterX][hitAreaCenterY] -= ATTACK;
		attackAnimalArray[hitAreaCenterX][hitAreaCenterY][0] = null;
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2 ; j++) {
				attackAreaArray[attackAreaCenterX + j][attackAreaCenterY + i]--;
			}
		}
		
	}

	@Override
	public void attackAreaHitTest(DisplayComponent dc, int physicalAttackPower) {
		// TODO Auto-generated method stub
		if (dc.getCh().getMotionNum() == 3) {
			
			iceArrow = new IceArrow();
			dc.getEffect().add(iceArrow);
			iceArrow.moveMotion(dc, attackAreaCenterX, attackAreaCenterY, physicalAttackPower + this.physicalAttackPower);
			
			
		}
	}


}
