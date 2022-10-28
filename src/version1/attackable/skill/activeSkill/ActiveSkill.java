package attackable.skill.activeSkill;

import attackable.AttackGetSetable;
import attackable.Attackable;
import attackable.skill.Skill;
import displayComponent.displayObject.DisplayObject;
import item.Nameable;
import item.weapon.characterWeapon.CharacterWeapon;


public abstract class ActiveSkill extends Skill implements AttackGetSetable {
	
	
	
	// ��� ��ų 1,2�� ���������� ����Ʈ�� �����ϱ� ������ �̰͵��� �ʿ����. ���� �ʿ�???
	
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
