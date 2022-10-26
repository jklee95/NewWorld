package attackable.skill.characterSkill.daggerSkill;

import attackable.effect.daggerEffect.ThrowingDagger;
import attackable.skill.Skillable;
import attackable.skill.activeSkill.specialSkill.MagicalActiveSkill;
import displayComponent.displayObject.animal.Animal;
import gui.mainUI.roundUI.PlayUI;

public class DaggerSkill1 extends MagicalActiveSkill implements SkillManager {
	
	private ThrowingDagger tDagger;

	public DaggerSkill1(int skillLevel) {
		
		this.skillName = "ǥâ ������";
		this.skillLevelMax = 10;
		this.skillContents = "���� ������������ ǥâ�� ������.";
		
		this.attackedEnemyContent = "�ټ�";
		
		this.tDagger = new ThrowingDagger(attackPower, attackPowerPer, attackCount, 1);

		
		setSkillLevelCurrent(skillLevel); 
		
	}
	
	// �⺻ �ɷ�ġ ����
	protected void resetAbility() {
		
		// �⺻��
		this.attackPowerPer = 100;
		this.decreaseMp = 0;
		this.attackCount = 1;
		
		// ������
		this.attackPowerValue = 5;
		this.attackCountValue = 1;
		this.decreaseMpValue = 5;
		
		// ������
		this.attackPowerTerm = 1;
		this.attackCountTerm = 6;
		this.decreaseMpTerm = 3; 
	}
	
	public void attackAreaPlus(Animal animal) {
		
		tDagger.attackAreaPlus(animal);
		
	}

	public void attackAreaMinus(Animal animal) {
		
		tDagger.attackAreaMinus(animal);
		
	}

	public void attackAreaHitTest(Animal attacker) {
		int motionNum = attacker.getMotionNum();
		if (motionNum == 3) {
			

			this.tDagger = new ThrowingDagger(attackPower, attackPowerPer, attackCount, 1);
			PlayUI.getDisplayComponent().getEffect().add(tDagger);
			tDagger.attackAreaHitTest(attacker);
		
		
		
		}
	}
	
	public Skillable makeSkill(int skillLevel) {
		return new DaggerSkill1(skillLevel);
	}


}
