package attackable.skill.characterSkill.daggerSkill;

import attackable.skill.PassiveSkill;
import attackable.skill.Skillable;
import item.Nameable;
import item.weapon.characterWeapon.dagger.Dagger;

public class DaggerSkill3 extends PassiveSkill {
	
	
	private final int MAX = 10;
	
	private int attackPowerPer;
	private int vitalSkillPer;
	
	private int attackPowerValue;
	private int vitalSkillValue;
	
	private int attackPowerTerm;
	private int vitalSkillTerm;
	
	

	public DaggerSkill3(int skillLevel) {
		
		this.skillName = "�ϻ����� ����";
		this.skillLevelMax = MAX;
		this.skillContents = "�ϻ� ��ų�� �߰�Ÿ�� �ο��Ѵ�.";
		
		
		setSkillLevelCurrent(skillLevel); 
		
	}
	
	public void setSkillAbilityContents() {
		this.skillAbilityContents_1 = "�ϻ� ��ų ���� " + "�������ݷ� " + attackPowerPer + "% �߰� �ο�";

		this.skillAbilityContents_2 = vitalSkillPer + "% Ȯ���� �ߵ�";
	}
	
	// �⺻ �ɷ�ġ ����
	protected void resetAbility() {

		// �⺻��
		this.attackPowerPer = 50;
		this.vitalSkillPer = 20;
		
		// ������
		this.attackPowerValue = 5;
		this.vitalSkillValue = 5;
		// ������
		this.attackPowerTerm = 2;
		this.vitalSkillTerm = 1;
		
	}
	
	public void setSkillLevelCurrent(int skillLevelCurrent) {
		this.skillLevelCurrent += skillLevelCurrent;
		
		resetAbility();
		
		for (int i = 1; i <= this.skillLevelCurrent; i++) {
			if (i % attackPowerTerm == 0) attackPowerPer += attackPowerValue;
			if (i % vitalSkillTerm == 0) vitalSkillPer += vitalSkillValue;
		}
		
		setSkillAbilityContents();

	}
	
	public Skillable makeSkill(int skillLevel) {
		return new DaggerSkill3(skillLevel);
	}
	
	

	
	public int getAttackPowerPer() {
		return attackPowerPer;
	}

	public int getVitalSkillPer() {
		return vitalSkillPer;
	}
}
