package item.weapon.characterWeapon;

import attackable.skill.Skillable;
import attackable.skill.characterSkill.daggerSkill.SkillManager;
import item.weapon.Weapon;

public abstract class CharacterWeapon extends Weapon {

	// �⺻ �ɷ�ġ
    protected int requiredLevel;
    protected int durability;
    protected int weaponType;
    
    
	public int getRequiredLevel() {
		return requiredLevel;
	}

	public int getWeaponType() {
		return weaponType;
	}
	
	
	// ��ų �޼ҵ��
	
	
	public abstract void skillChange(int skillNum);
	public abstract SkillManager smChange(int skillNum);
	
	public int getDecreaseMp(int skillNum) {
		
		SkillManager tempSm = smChange(skillNum);
		
		return tempSm.getDecreaseMp();
	}
	

}
