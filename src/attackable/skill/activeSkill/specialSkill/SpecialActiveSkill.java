package attackable.skill.activeSkill.specialSkill;

import item.Nameable;
import attackable.skill.Skillable;
import attackable.skill.activeSkill.ActiveSkill;

public abstract class SpecialActiveSkill extends ActiveSkill implements Nameable, Skillable {

	
	protected int skillLevelCurrent;
	protected int skillLevelMax;
	
	// 공격횟수
	protected int attackCount;
	protected int attackCountTerm;
	protected int attackCountValue;
	
	// 마력
	protected int decreaseMp;
	protected int decreaseMpTerm;
	protected int decreaseMpValue;
	
	// 공격력
	protected int attackPowerPer;
	protected int attackPowerTerm;
	protected int attackPowerValue;

	
	// 기타
	protected String skillName;
    protected String skillContents;
    protected String attackedEnemyContent;
    
    protected String skillAbilityContents_1;
    protected String skillAbilityContents_2;
    
    
    
    
    public void setSkillAbilityContents() {
    	this.skillAbilityContents_1 = skillStat + " " + attackPowerPer + "%"
				+ ", " + attackedEnemyContent + "의 적을" + " " + attackCount + "번 공격";
    	
    	this.skillAbilityContents_2 = "마력 " + decreaseMp + "감소";
    }

    
    
    // Nameable 추상화
	public String getInstanceName() {
		return skillName;
	}
	
	// Skillable 추상화
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

	
	// Manager 추상화
	public int getDecreaseMp() {
		return decreaseMp;
	}
	

	// AttackGetSetable 추상화
	public int getAttackPowerPer() {
		return attackPowerPer;
	}
	
	
	
	
	// 무기 공격력을 스킬에 추가 해줄떄 쓰는 메소드
	// 평타엔 필요없어 special 클래스에만 추가해줌
	// 자세한 건 Dagger 클래스 참고
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
