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
		
		this.skillName = "암살자의 결의";
		this.skillLevelMax = MAX;
		this.skillContents = "암살 스킬에 추가타를 부여한다.";
		
		
		setSkillLevelCurrent(skillLevel); 
		
	}
	
	public void setSkillAbilityContents() {
		this.skillAbilityContents_1 = "암살 스킬 사용시 " + "물리공격력 " + attackPowerPer + "% 추가 부여";

		this.skillAbilityContents_2 = vitalSkillPer + "% 확률로 발동";
	}
	
	// 기본 능력치 설정
	protected void resetAbility() {

		// 기본값
		this.attackPowerPer = 50;
		this.vitalSkillPer = 20;
		
		// 증가값
		this.attackPowerValue = 5;
		this.vitalSkillValue = 5;
		// 증가텀
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
