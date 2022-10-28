package attackable.skill.activeSkill;

import attackable.AttackGetSetable;
import attackable.Attackable;
import attackable.skill.Skill;
import displayComponent.displayObject.DisplayObject;
import item.Nameable;
import item.weapon.characterWeapon.CharacterWeapon;


public abstract class ActiveSkill extends Skill implements AttackGetSetable {
	
	
	
	// 대거 스킬 1,2는 실질적으로 이펙트가 공격하기 떄문에 이것들이 필요없음. 수정 필요???
	
	protected int attackAreaCenterX = DisplayObject.EXTRA_ARRAY / 2;
	protected int attackAreaCenterY = DisplayObject.EXTRA_ARRAY / 2;
	protected int attackDistance;
	
    
	public void setAttackAreaCenterX(int attackAreaCenterX) {
		this.attackAreaCenterX = attackAreaCenterX;
	}


	public void setAttackAreaCenterY(int attackAreaCenterY) {
		this.attackAreaCenterY = attackAreaCenterY;
	}
	


	public int getAttackDistance() {
		return attackDistance;
	}
	


	protected int attackPower;


	public int getAttackPower() {
		return attackPower;
	}

	
}
