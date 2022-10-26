package attackable.skill.characterSkill.daggerSkill;

import attackable.effect.daggerEffect.ThrowingDagger;
import attackable.skill.Skillable;
import attackable.skill.activeSkill.specialSkill.MagicalActiveSkill;
import displayComponent.displayObject.animal.Animal;
import gui.mainUI.roundUI.PlayUI;

public class DaggerSkill1 extends MagicalActiveSkill implements SkillManager {
	
	private ThrowingDagger tDagger;

	public DaggerSkill1(int skillLevel) {
		
		this.skillName = "표창 던지기";
		this.skillLevelMax = 10;
		this.skillContents = "전방 직선방향으로 표창을 던진다.";
		
		this.attackedEnemyContent = "다수";
		
		this.tDagger = new ThrowingDagger(attackPower, attackPowerPer, attackCount, 1);

		
		setSkillLevelCurrent(skillLevel); 
		
	}
	
	// 기본 능력치 설정
	protected void resetAbility() {
		
		// 기본값
		this.attackPowerPer = 100;
		this.decreaseMp = 0;
		this.attackCount = 1;
		
		// 증가값
		this.attackPowerValue = 5;
		this.attackCountValue = 1;
		this.decreaseMpValue = 5;
		
		// 증가텀
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
