package attackable.skill;

import item.Nameable;

public abstract class PassiveSkill extends Skill implements Nameable, Skillable {


	protected int skillLevelCurrent;
	protected int skillLevelMax;
	
	protected String skillName;
    protected String skillContents;
    
    protected String skillAbilityContents_1;
    protected String skillAbilityContents_2;
    

    
    protected abstract void resetAbility();
    
    
    // Skillable √ﬂªÛ»≠
	public String getInstanceName() {
		return skillName;
	}
	
	public String getSkillContents() {
		return skillContents;
	}

	public int getSkillLevelCurrent() {
		return skillLevelCurrent;
	}

	public int getSkillLevelMax() {
		return skillLevelMax;
	}
	
	public String getSkillAbilityContents_1() {
		return skillAbilityContents_1;
	}
    public String getSkillAbilityContents_2() {
    	return skillAbilityContents_2;
    }

}
