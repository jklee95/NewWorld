package attackable.skill.activeSkill.normalSkill;

import attackable.skill.activeSkill.ActiveSkill;

public abstract class NormalActiveSkill extends ActiveSkill {
	
	
	public NormalActiveSkill() {
		this.skillStat = "물리공격력";
	}
	
	
	public int getDecreaseMp() {
		return 0;
	}
	

	
	public int getAttackPowerPer() {
		return 100;
	}

}
