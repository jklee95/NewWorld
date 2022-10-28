package attackable.skill.activeSkill.specialSkill;

import item.Nameable;
import attackable.skill.Skillable;
import attackable.skill.activeSkill.ActiveSkill;

public abstract class SpecialActiveSkill extends ActiveSkill implements Nameable, Skillable {

	
	protected int skillLevelCurrent;
	protected int skillLevelMax;
	
	// ����Ƚ��
	protected int attackCount;
	protected int attackCountTerm;
	protected int attackCountValue;
	
	// ����
	protected int decreaseMp;
	protected int decreaseMpTerm;
	protected int decreaseMpValue;
	
	// ���ݷ�
	protected int attackPowerPer;
	protected int attackPowerTerm;
	protected int attackPowerValue;

	
	// ��Ÿ
	protected String skillName;
    protected String skillContents;
    protected String attackedEnemyContent;
    
    protected String skillAbilityContents_1;
    protected String skillAbilityContents_2;
    
    
    
    
    public void setSkillAbilityContents() {
    	this.skillAbilityContents_1 = skillStat + " " + attackPowerPer + "%"
				+ ", " + attackedEnemyContent + "�� ����" + " " + attackCount + "�� ����";
    	
    	this.skillAbilityContents_2 = "���� " + decreaseMp + "����";
    }

    
    
    // Nameable �߻�ȭ
	public String getInstanceName() {
		return skillName;
	}
	
	// Skillable �߻�ȭ
	public int getSkillLevelCurrent() {
		return skillLevelCurrent;
	}


	public int getSkillLevelMax() {
		return skillLevelMax;
	}


	public String getSkillContents() {
		return skillContents;
	}
	
	public String getSkillAbilityContents_1() {
		return skillAbilityContents_1;
	}
    public String getSkillAbilityContents_2() {
    	return skillAbilityContents_2;
    }

	
	// Manager �߻�ȭ
	public int getDecreaseMp() {
		return decreaseMp;
	}
	

	// AttackGetSetable �߻�ȭ
	public int getAttackPowerPer() {
		return attackPowerPer;
	}
	
	
	
	
	// ���� ���ݷ��� ��ų�� �߰� ���ً� ���� �޼ҵ�
	// ��Ÿ�� �ʿ���� special Ŭ�������� �߰�����
	// �ڼ��� �� Dagger Ŭ���� ����
	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	
	

    protected abstract void resetAbility();
	

	
	public void setSkillLevelCurrent(int skillLevelCurrent) {
		this.skillLevelCurrent += skillLevelCurrent;
		
		resetAbility();
		
		for (int i = 1; i <= this.skillLevelCurrent; i++) {
			if (i % attackPowerTerm == 0) attackPowerPer += attackPowerValue;
			if (i % attackCountTerm == 0) attackCount += attackCountValue;
			if (i % decreaseMpTerm == 0) decreaseMp += decreaseMpValue;
		}
		
		setSkillAbilityContents();

	}
	
	
}
